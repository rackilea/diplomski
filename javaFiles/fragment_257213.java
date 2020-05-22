import java.util.ArrayList;
public class SUB_ARRAY{
    public static int SUBARRAY_MINIMUM_LENGTH = 2;
    public static void main(String a[]){
        ArrayList<Integer> x = new ArrayList<Integer>();
        x.add(5);
        x.add(0);
        x.add(1);
        x.add(3);
        x.add(4);
        x.add(2);
        x.add(3);
        x.add(6);
        x.add(1);
        x.add(0);
        x.add(4);
        int monoton = 0;
        int changed = -1;
        System.out.println("Initial array: " + x.toString());
        for ( int i=0; i< x.size() -1; ++i){
            if (x.get(i+1) > x.get(i)){
                if (changed > -1){
                    for (int j = changed; j <i+2; ++j){
                        monoton += checkSubArray(x, j, i+2);;
                    }
                }
                else{
                    System.out.println("New monoton subarray start index: " + i + " value: " + x.get(i));
                    changed = i;
                    monoton += checkSubArray(x, changed, i+2);
                }
            }
            else if (changed > -1){
                changed = -1;
            }
        }    
        System.out.println("Monoton count: " + monoton);
    }    

    private static int checkSubArray(ArrayList<Integer> x, int start, int end)
    {
        if (end-start < SUBARRAY_MINIMUM_LENGTH){ 
            return 0;
        }
        for (int subi = start; subi < end; ++subi){
            System.out.print(" " + x.get(subi));
        }
        System.out.println();
        return 1;
    }
}