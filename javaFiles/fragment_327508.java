@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class TreeAnnotationProcessor extends AbstractProcessor{

  private Trees trees;
  private Tree tree;

  @Override
  public synchronized void init(ProcessingEnvironment processingEnv) {
    super.init(processingEnv);
    trees = Trees.instance(processingEnv);
  }

  @Override
  public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    for (Element element : roundEnv.getRootElements()) {
      tree = trees.getTree(element);

      try {
        Method cloneMethod = tree.getClass().getMethod("clone");
        Object cloneTree = cloneMethod.invoke(tree);
        this.tree = (Tree) cloneTree;
      } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
        e.printStackTrace();
      }
    }

    return true;
  }

  public Tree getTree() {
    return tree;
  }
}