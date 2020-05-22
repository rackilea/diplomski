import java.lang.NoSuchMethodException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class MyButton {
    private Object onClickObject;
    private Method onClickMethod;

    public void OnClick(Object object, String methodName) throws NoSuchMethodException {
        OnClick(object, object.getClass().getMethod(methodName));
    }

    public void OnClick(Object object, Method method) {
        this.onClickObject = object;
        this.onClickMethod = method;
    }

    // MyButton calls this method every time the button is clicked, in
    // order to inform the external event handler about it
    protected void onClick() throws IllegalAccessException, InvocationTargetException {
        onClickMethod.invoke(onClickObject);
    }
}