// The CustomView "IS-A" ImageView, so you can perform ImageView operations
// on your custom object. You can even choose to override ImageView methods.
public class CustomView extends ImageView {
    Object myObj;

    public CustomView(Context context, Object myObj) {
        super(context);
        this.myObj = myObj;
    }
}