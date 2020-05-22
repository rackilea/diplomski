import org.mozilla.javascript.NativeJavaMethod;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Scriptable;
public class InterceptNativeObject extends NativeJavaObject {
    @Override
    public Object get(String name, Scriptable start) {
        Object res = super.get(name, start);
        System.out.println("Field get name="+name+" result="+res);
        if (res instanceof NativeJavaMethod) {
            NativeJavaMethod method = (NativeJavaMethod) res;
            return new JavaMethodWrapper(method);
        }
        return res;
    }
    public InterceptNativeObject(Scriptable scope, Object javaObject,
            Class<?> staticType) {
        super(scope, javaObject, staticType);
    }
}