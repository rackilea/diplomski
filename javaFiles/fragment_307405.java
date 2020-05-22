private Context ctx = null;

public void onCreate(Bundle bundle) {
    super.onCreate(bundle);
    // your other code
    ctx = getApplication();

    MyClass myClass = new MyClass(ctx);
}