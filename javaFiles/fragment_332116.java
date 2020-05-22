import java.util.*

public class printonscreen{
    public static void main(String args[]){
        ArrayList<Integer> test = new ArrayList<Integer>();
        test.add(0);
        test.add(1);
        test.add(2);
        test.add(4);
        Scanner s = new Scanner (System.in);
        for(int i=0; i<test.size(); i++){
             System.out.print(test.get(i));

             // wait user press enter
             s.nextLine();
        }
    }
}