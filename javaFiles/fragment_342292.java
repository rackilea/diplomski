public class SomeClass {
  private final ProcessingEnvironment pe = /* get it somewhere */;
  private final Types typeUtils = pe.getTypeUtils();

  public TypeElement getExtracted(VariableElement ve) {
    TypeMirror typeMirror = ve.asType();
    Element element = typeUtils.asElement(typeMirror);

    // instanceof implies null-ckeck
    return (element instanceof TypeElement)
        ? (TypeElement)element : null;
  }
}