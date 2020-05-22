import jsinterop.annotations.JsMethod;
import jsinterop.annotations.JsType;

@JsType(isNative=true, namespace = "com.gwidgets")
public class Spring {

    @JsMethod
    public native String getName();
}