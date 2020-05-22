public class SimpleJob implements JobI {
    @Override
    public void execute(Object[] args) {
        for (Object o : args) {
            // String[] array = o.toString().split("=");
            System.out.println(o.toString());
        }
    }
}