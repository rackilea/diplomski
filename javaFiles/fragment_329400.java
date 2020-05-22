@Beta
static class Util extends DelegateProcessor.Util { // this is where I want to later override some methods.

    extension TransformationContext context

    new(TransformationContext context) {
        super(context)
        this.context = context
    }

    override getDelegates(TypeDeclaration it) {
        declaredMembers.filter[findAnnotation(findTypeGlobally(DelegateDeclared)) !== null]
    }

    override listedInterfaces(MemberDeclaration it) {
        findAnnotation(findTypeGlobally(DelegateDeclared)).getClassArrayValue("value").toSet
    }

}