import java.util.Vector;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.mozilla.javascript.ScriptableObject;


public class InterceptTest {
    public static void main(String[] args) {
        Context cx=Context.enter();
        cx.setWrapFactory(new InterceptWrapFactory());
        Scriptable root=cx.initStandardObjects();
        ScriptableObject.putProperty(root,"v", new Vector<String>());
        cx.evaluateString(root, "v.add('foo'); v.get(0)", "src", 1, null);
    }
}