public class Main {

    public static void main(String[] args) {
       List<Dummy> dummies = new LinkedList<Dummy>();
       dummies.add(new Dummy("abc.com.core"));
       dummies.add(new Dummy(""));
       dummies.add(new Dummy("abc.com.core.def"));

       System.out.println("BEFORE : " + dummies);
       Collections.sort(dummies);
       System.out.println("AFTER : " + dummies);
    }
}