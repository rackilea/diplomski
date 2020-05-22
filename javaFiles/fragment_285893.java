import java.lang.reflect.InvocationTargetException;
public class Reflection
{

    public static void main( String[] args )
    {
        MyParent p = new MyParent();
        setParentKey( p, "parentKey" );

        MyObj o = new MyObj();
        setParentKey( o, "myParentKey" );
        setMyKey( o, "myKey" );

        System.out.println( "p = " + p );
        System.out.println( "o = " + o );

    }



    public static void invokeMethod( Object p, Object k, String methodName )
    {
        try
        {
            p.getClass().getMethod( methodName, k.getClass() ).invoke( p, k );
        }
        catch ( NoSuchMethodException e )
        {
            e.printStackTrace();
        }
        catch ( InvocationTargetException e )
        {
            e.printStackTrace();
        }
        catch ( IllegalAccessException e )
        {
            e.printStackTrace();
        }
    }

    public static void setParentKey( Object p, Object k )
    {
           invokeMethod( p,k,"setParentKey" );
    }

    public static void setMyKey( Object p, Object k )
    {
        invokeMethod( p,k,"setMyKey" );
    }

    public static class MyParent
    {
        private Object parentKey;
        public void setParentKey( String k )
        {
            parentKey = k;
        }

        @Override
        public String toString()
        {
            return "MyParent{" +
                           "parentKey=" + parentKey +
                           '}';
        }
    }

    public static class MyObj extends MyParent
    {
        private Object myKey;
        public void setMyKey( String k )
        {
            myKey = k;
        }

        @Override
        public String toString()
        {
            return "MyObj{" +
                           "myKey=" + myKey +
                           "} " + super.toString();
        }
    }
}