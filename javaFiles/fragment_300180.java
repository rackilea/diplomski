VariableElement parameterElement;
ProcessingEnvironment processingEnv;

TypeMirror parameterType = parameterElement.asType();
Types typeUtils = processingEnv.getTypeUtils();
TypeElement typeElement = (TypeElement) typeUtils.asElement(parameterType);
Elements elementUtils = processingEnv.getElementUtils()
List<? extends Element> elementMembers = elementUtils.getAllMembers(typeElement);
List<ExecutableElement> elementMethods = ElementFilter.methodsIn(elementMembers);
for(ExecutableElement methodElement : elementMethods) {
    if (methodElement.getParameters().size()==0 && methodElement.getSimpleName().toString().startsWith("get")) {
      // do something
    }
}