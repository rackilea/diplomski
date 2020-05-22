@SuppressWarnings("rawtypes")
public static class MyLayoutInflaterFactory implements LayoutInflater.Factory2 {

    private static final Class<?>[] constructorSignature = new Class[] {Context.class, AttributeSet.class };

    final MutableContextWrapper mutableContextWrapper;

    public MyLayoutInflaterFactory(MutableContextWrapper mutableContextWrapper) {
        this.mutableContextWrapper = mutableContextWrapper;
    }

    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        Constructor<? extends View> constructor = null;
        Class<? extends View> clazz = null;
        try {
            clazz = mutableContextWrapper.getClassLoader().loadClass(name).asSubclass(View.class);
            constructor = clazz.getConstructor(constructorSignature);
            constructor.setAccessible(true);
            return constructor.newInstance(mutableContextWrapper, attrs);
        } catch (Throwable t) {
            return null;
        }
    }

    @Override
    public View onCreateView(View parent, String name, Context context, AttributeSet attrs) {
        // Perhaps this can be done better
        return onCreateView(name, context, attrs);
    }
}

public static class MyLayoutInflater extends LayoutInflater {

    protected MyLayoutInflater(Context context) {
        super(context);
    }

    @Override
    public LayoutInflater cloneInContext(Context newContext) {
        return new MyLayoutInflater(newContext);
    }
}