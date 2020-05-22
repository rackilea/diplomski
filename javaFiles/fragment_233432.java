import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.common.types.JvmAnnotationReference
import org.eclipse.xtext.common.types.JvmAnnotationType
import org.eclipse.xtext.common.types.JvmType
import org.eclipse.xtext.common.types.TypesFactory
import org.eclipse.xtext.common.types.util.TypeReferences
import org.eclipse.xtext.example.domainmodel.domainmodel.Entity
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.eclipse.xtext.xbase.jvmmodel.AbstractModelInferrer
import org.eclipse.xtext.xbase.jvmmodel.IJvmDeclaredTypeAcceptor
import org.eclipse.xtext.xbase.jvmmodel.JvmAnnotationReferenceBuilder
import org.eclipse.xtext.xbase.jvmmodel.JvmTypesBuilder
import org.eclipse.xtext.common.types.JvmStringAnnotationValue

class DomainmodelJvmModelInferrer extends AbstractModelInferrer {

    @Inject extension JvmTypesBuilder
    @Inject extension IQualifiedNameProvider

    def dispatch infer(Entity entity, extension IJvmDeclaredTypeAcceptor acceptor, boolean prelinkingPhase) {
        accept(entity.toClass(entity.fullyQualifiedName)) [
            documentation = entity.documentation
            members += entity.toMethod("demo", Void.TYPE.typeRef) [
                annotations +=
                    entity.toAnnotationRef("org.eclipse.xtext.example.domainmodel.lib.Demo", "a" -> "Hallo",
                        "b" -> "Welt", "c" -> "!")
                body = ''''''
            ]
        ]
    }

    @Inject
    private TypesFactory typesFactory;

    @Inject
    private TypeReferences references;

    def toAnnotationRef(EObject context, String annotationTypeName, Pair<String, String> ... values) {
        val JvmAnnotationReference result = typesFactory.createJvmAnnotationReference();
        val JvmType jvmType = references.findDeclaredType(annotationTypeName, context);
        if (jvmType == null) {
            throw new IllegalArgumentException("The type " + annotationTypeName + " is not on the classpath.");
        }
        if (!(jvmType instanceof JvmAnnotationType)) {
            throw new IllegalArgumentException("The given class " + annotationTypeName + " is not an annotation type.");
        }
        val jvmAnnotationType = jvmType as JvmAnnotationType

        result.setAnnotation(jvmAnnotationType);
        for (value : values) {
            val JvmStringAnnotationValue annoValue = typesFactory.createJvmStringAnnotationValue
            annoValue.values += value.value
            annoValue.operation = jvmAnnotationType.declaredOperations.findFirst[simpleName == value.key]
            result.explicitValues.add(annoValue)
        }
        return result

    }

}