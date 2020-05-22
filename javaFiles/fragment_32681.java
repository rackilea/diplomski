BigInteger a = new BigInteger( "123456789101112" );
    Method mod2 = null;
    try {
        mod2 = BigInteger.class.getDeclaredMethod( "mod2", int.class );
    } catch (NoSuchMethodException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (SecurityException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    //Class[] arg_types = new Class[1];
    //arg_types[0] = int.class;
    //Method mod2 = BigInteger.class.getDeclaredMethod( "mod2", arg_types );
    mod2.setAccessible( true );
    Object b;
    try {
        b = mod2.invoke( a, 32 );
           System.out.print( b );
    } catch (IllegalAccessException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (IllegalArgumentException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } catch (InvocationTargetException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }