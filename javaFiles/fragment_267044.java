public class Solution {

    private Scanner s;

    public static void main(String[] args) {

        s = new Scanner(System.in); // initialize only once
        check(1);
    }

    public static void check(int count) {
        if(s.hasNext()) {
            String ns = s.nextLine();
            System.out.println(count + " " + ns);
            check(count + 1);
        }
    }   
}