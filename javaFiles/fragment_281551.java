import com.squareup.javapoet.*;
import javax.lang.model.element.Modifier;
import java.io.IOException;

public class AttemptGeneric {

  public static void main(String[] args) throws IOException {

    ClassName myClass = ClassName.get("com", "MyClass");
    ClassName myOtherClass = ClassName.get("com", "MyOtherClass");
    ClassName myInterface = ClassName.get("com", "MyInterface");
    TypeVariableName typeVariableName = TypeVariableName.get("T", myClass);

    MethodSpec methodSpec = MethodSpec.methodBuilder("someMethod")
            .returns(myOtherClass)
            .addModifiers(Modifier.PUBLIC, Modifier.STATIC)
            .addTypeVariable(typeVariableName.withBounds(myInterface))
            .addParameter(typeVariableName,"type")
            .build();


    TypeSpec genericClass = TypeSpec.classBuilder("GenericImpl")
            .addModifiers(Modifier.PUBLIC, Modifier.FINAL)
            .addMethod(methodSpec)
            .build();

    JavaFile javaFile = JavaFile.builder("com", genericClass)
            .build();

    javaFile.writeTo(System.out);

  }
}