import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    /**
     * Method insertionSort
     * This method sorts ArrayList list made of generic T elements
     * @param list the ArrayList to be sorted
     */
    public static <T extends Comparable<T>> void insertionSort(List<T> list){
        T temp;
        int position;
        int size = list.size();
        for(int i = 1; i < size; i++){
            temp = list.get(i);
            position = i;
            while(position > 0 && list.get(position-1).compareTo(temp) > 0){
                //Shift bigger values to the right
                list.set(position, list.get(position-1));
                position--;
            }
            list.set(position, temp);
            System.out.println("Sorting... " + ((double)i/(double)size)*100.0 + "%");
        }
    }

    public static void main(String args[]) {
        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<>(Arrays.asList(10,6,3,8,1,7,2,9,5,4));

        App.insertionSort(list);

        Double secondsLenght = (System.nanoTime()-startTime)/ Math.pow(10, 9);

        System.out.println(list);
        System.out.println("Sorting took " + secondsLenght + " seconds.");

    }
}