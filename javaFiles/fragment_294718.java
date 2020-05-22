public class App extends Application {

  private ObjectGraph graph;

  @Override public void onCreate() {
    super.onCreate();

    graph = ObjectGraph.create(Modules.getModules(this).toArray());
  }

  public void inject(Object object) {
    graph.inject(object);
  }
}