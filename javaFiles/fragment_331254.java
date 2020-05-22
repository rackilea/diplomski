public class Bar {
    Class c = Class.forName("Foo");
    Method m = c.getDeclaredMethod("doThis",null);
    try {
        m.invoke(null,null);
    } catch (InvocationTargetException e) {
       if (e.getCause() instanceof CannotDoThisException) {
           // do something about it
       } else {
           // do something else
           // if the `cause` exception is unchecked you could rethrow it.
       }
    }
}