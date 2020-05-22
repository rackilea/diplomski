class SuperClass {
    //...
}

class SubClass1 extends SuperClass {
    //...
}

class SubClass2 extends SuperClass {
    //...
}

class Context {
    //...
}

abstract class View {
    private final Context context;

    public View(Context context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

class TextBox extends View {

    public TextBox(Context context) {
        super(context);
    }
}

class CheckBox extends View {

    public CheckBox(Context context) {
        super(context);
    }
}