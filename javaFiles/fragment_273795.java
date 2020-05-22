public class TheListener<T> ... {
    private final Model<T> model;

    public TheListener(Model<T> model) {
        this.model = model;
    }

    public void onClick(...) {
        ...
        // read access
        model.getFieldValue();
        ...
        // write access
        model.setFieldValue(v);
        ...
    }
}