import java.util.Random;

public class weqfgtqertg {
    public static void main(String args[]) {
        int array0Through999[] = {0,1,...,999};
        int loopTotal3 = 0;
        Random rand = new Random();
        for(int y = 0; y < 1000; y++){
            //System.out.println("Reference1");
            System.out.println(y);
            int first = 0;
            int last = array0Through999.length - 1;
            int third = (first + last) / 3;

            int findThis3 = rand.nextInt(1000);
            int loop3 = 0;
            while(first <= last) {
                //System.out.println("Reference1");
                loop3++;
                 if (array0Through999[third] < findThis3){
                     //System.out.println("Reference3");
                     first = third+1;
                 }
                 else if(array0Through999[third] ==  findThis3){
                     //System.out.println("Reference4");
                     break;
                 }
                 else{
                     //System.out.println("Reference5");
                     last = third-1;
                 }
                 int calc = last - first;
                 third = first + (calc/3);
            }//end while
            loopTotal3 = loopTotal3 + loop3;
        }//end for
        int loopAverage3 = loopTotal3 / 1000;
        System.out.println("The average number of times for a Tertiary Search is: " + loopAverage3);
    }
}