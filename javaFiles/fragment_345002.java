public class GenericArgsMBeanTest {

    public static final MBeanServer SERVER = ManagementFactory.getPlatformMBeanServer();

    public static void main(String[] args) {
        log("GenericArgsMBeanTest");
        try {
            ObjectName on = new ObjectName("test:svc=Generic");
            SERVER.registerMBean(new GenericOpService(), on);
            // invoking public String op(List<Date> dates);
            List<Date> dates = new ArrayList<Date>(Arrays.asList(new Date[]{
                    new Date(System.currentTimeMillis()),
                    new Date(System.currentTimeMillis()-1000),
                    new Date(System.currentTimeMillis()-10000)
            }));
            String result = (String)SERVER.invoke(on, "op", new Object[]{dates}, new String[]{List.class.getName()});
            // Note: We need to use the List class name, not ArrayList.
            log("Result:\n" + result);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }


    public static void log(Object msg) {
        System.out.println(msg);
    }
}