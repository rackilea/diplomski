public class Info {

    public String a;
    public int b;

    private Info(Object [] args) {
        a = (String) args[0];
        b = (Integer) args[1];
    }

    public static Info[] create(Object[]...args) {
        Info[] result = new Info[args.length];
        int count = 0;
        for (Object[] arg : args) {
            result[count++] = new Info(arg);
        }
        return result;
    }

    public static void main(String [] args) {
        Info[] data = Info.create(new Object[][] {{"StringA", 1}, {"StringB", 2}, {"StringC", 3}});
    }

}