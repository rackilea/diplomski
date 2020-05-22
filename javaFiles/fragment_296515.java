import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Nt {
    public static void main(String[] args) {
        int processors = Runtime.getRuntime().availableProcessors();
        System.out.println(Integer.toString(processors) + " processor"
            + (processors != 1 ? "s are " : " is ")
            + "available");

        int arr[]={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
        t test=new t(arr);

        ForkJoinPool pool = new ForkJoinPool();

        long startTime = System.currentTimeMillis();
        pool.invoke(test);
        long endTime = System.currentTimeMillis();

        System.out.println("Takes " + (endTime - startTime) + 
            " milliseconds.");

    }
}
class t extends RecursiveAction{


    private final int array[];
    private final int min;
    private final int max;
    private final int th=4;

    public t (int array[]){
        this(array, 0, array.length);
    }

    public t (int array[], int min, int max){
        this.array=array;
        this.min = min;
        this.max = max;

        System.out.println("Task to handle range "+min+" to "+max);
    }

    protected void compdir(){

        for (int i=min;i<max;i++){
            array[i]=array[i]+3;
        }
    }

    @Override
    protected void compute(){
        if (max-min<th) {      
            compdir();
        } else {

            int center = min + (max - min) / 2;
            invokeAll(new t(array, min, center) , new t(array, center+1, max));
        }
    }

}