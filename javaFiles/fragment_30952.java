@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_6)
public class OutputRoundProcessor extends AbstractProcessor {
  private int round = 0;
  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    System.out.println("Round: " + round);
    for (Element element : roundEnv.getRootElements()) {
      System.out.printf("%s = %s (%s)\n", element.getSimpleName(), element.asType(), element.asType().getKind());
    }
    round++;
    return false;
  }
}