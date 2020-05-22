import java.lang.reflect.Method;
import org.apache.velocity.util.introspection.Info;
import org.apache.velocity.util.introspection.UberspectImpl;
import org.apache.velocity.util.introspection.VelMethod;

public class CustomUberspector extends UberspectImpl {

public VelMethod getMethod(Object obj, String methodName, Object[] args, Info i)
        throws Exception  {

        if (obj == null) return null;

        VelMethod vm = super.getMethod(obj, methodName, args, i);
        if(vm != null) return vm;

        Object[] iargs = {methodName, new Object[] {}} ;
        Method m = introspector.getMethod(obj.getClass(), "run", iargs);
        if (m != null) return new PortalVelMethodImpl(m, methodName);

        return null;
}

public class PortalVelMethodImpl extends VelMethodImpl {
    final Method method;
    final String name;

    public PortalVelMethodImpl(Method m, String methodName) {
        super(m);
        method = m;
        name   = methodName;            
    }

    protected Object doInvoke(Object o, Object[] actual) throws Exception  {
        /* "run" method argumens are String and Object[] so we need to get plain Object[] array
         * From [Arg0,[Arg1..ArgN] to [Arg0,Arg1..ArgN]
         * */
        List<Object> args = new ArrayList<Object>();
        if(actual.length >= 1) {
            args.add(actual[0]);

            if(actual.length >= 2) {
                Object[] nestedArgs = (Object[])actual[1];
                for(int i=1; i<nestedArgs.length; i++) args.add(nestedArgs[i]);
            }
        }

        return method.invoke(o, name, args.toArray());
    }

}