public abstract class AbstractFunction implements Func {
  protected boolean isComplete;
  protected Set<Func> dependsOn;
  protected Set<Func> observedBy;
  protected ExecutorService service;
  protected String name;

  public AbstractFunction(String name, ExecutorService service) {
    observedBy = new HashSet<>();
    dependsOn = new HashSet<>();
    this.isComplete = false;
    this.service = service;
    this.name = name;
  }

  public void addObserver(Func f) {
    observedBy.add(f);
    f.addDependency(this);
  }

  public void addDependency(Func f) {
    dependsOn.add(f);
  }

  @Override
  public void onComplete() {
    this.isComplete = true;
    observedBy.forEach((f) -> f.onDependentComplete(this));
  }

  @Override
  public boolean isComplete() {
    return this.isComplete;
  }

  @Override
  public void change() { }

  @Override
  public void onDependentEvaluate(Func f) { }

  @Override
  public void onDependentComplete(Func func) { }
}