//First attempt
public class Name {

    public static void main(String[] args) {
        String n = new String("jennifer");
        String n2 = new String("paul");
        if (n.compareTo(n2) < 0) {
            System.out.println(n +" is before than " +n2);
        } else if (n.compareTo(n2) > 0) {
            System.out.println(n +" is after than " +n2);
        } else if (n.compareTo(n2) == 0) {
            System.out.println(n +" is equals to " +n);
        }
    }   
}