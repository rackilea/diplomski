public class MyClass {
    private final ObservableInt myField  = new ObservableInt();
    private final int data;
    {
       myField.addOnChangedListener(myListener);
    }

    public MyClass(int data) {
        this.data = data;
    }

    public MyClass(Bundle bundle) {
        this(bundle.getInt("SomeName"));
    }
}