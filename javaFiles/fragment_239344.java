public static void main(String[] args) {

    Lookup lookup = MethodHandles.lookup();
    NestedTestClass ntc = new Program().new NestedTestClass();

    try {
        // Grab method using normal reflection and make it accessible
        Method pm = NestedTestClass.class.getDeclaredMethod("gimmeTheAnswer");
        pm.setAccessible(true);

        // Now convert reflected method into method handle
        MethodHandle pmh = lookup.unreflect(pm);
        System.out.println("reflection:" + pm.invoke(ntc));

        // We can now revoke access to original method
        pm.setAccessible(false);

        // And yet the method handle still works!
        System.out.println("handle:" + pmh.invoke(ntc));

        // While reflection is now denied again (throws exception)
        System.out.println("reflection:" + pm.invoke(ntc));

    } catch (Throwable e) {
        e.printStackTrace();
    }

}