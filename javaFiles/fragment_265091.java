public class Main {

    public static void main(String[] args) 
    throws Exception {

        final List<Object> c1 = new ArrayList<Object>(Arrays.<Object>asList(1, 2, 3));
        for (Object o: c1) c1.remove(o);
    }
}