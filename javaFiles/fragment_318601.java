private static ObjectGraph staticRefToObjectGraph;

@Override
public void onCreate() {
    super.onCreate();

    staticRefToObjectGraph = ObjectGraph.create(new MyModule(this));
}

public static void inject(Object obj) {
    staticRefToObjectGraph.inject(obj);
}