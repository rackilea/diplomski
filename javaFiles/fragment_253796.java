public class DependencyTreeTask extends RecursiveAction {

  private final List<DependencyTreeTask> dependencies = new ArrayList<Task>();

  public void addDependency(DependencyTreeTask t) { dependencies.add(t) }

  public void compute() {
    invokeAll(dependencies);
  }

}

...
// build tree...
DependencyTreeTask root = ...
ForkJoinPool pool = new ForkJoinPool();
pool.invoke(root);