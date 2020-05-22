import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;


public class Main {

    public static void main(String[] args) {

        int n = Integer.parseInt(args[0]);
        long[] maxsubarray1;
        maxsubarray1 = new Generator(n, args[1]).getArray();
        long[] maxsubarray2 = Arrays.copyOf(maxsubarray1, maxsubarray1.length);
        long[] maxsubarray3 = Arrays.copyOf(maxsubarray1, maxsubarray1.length);

        System.out.println(Arrays.toString(maxsubarray1));
        solver solver = new solver();
        long solution;
        //if (args[5].equalsIgnoreCase("bruteforce")){
        long startTime = System.currentTimeMillis();
        solution = solver.bruteforce(maxsubarray1, n);
        System.out.println("__________BRUTE FORCE________\nThe sum of the array is " + solution);
        long endTime = System.currentTimeMillis() - startTime;
        System.out.println(endTime);
        //}
        //if (args[5].equalsIgnoreCase("divideconquer")){
        long startTime2 = System.currentTimeMillis();
        long solutiondivideconquer = solver.divideconquer(maxsubarray2, 0, n);
        System.out.println("__________DIVIDE AND CONQUERE________\nThe sum of the array is " + solutiondivideconquer);
        long endTime2 = System.currentTimeMillis() - startTime2;
        System.out.println(endTime2);
        //}
        //if (args[5].equalsIgnoreCase("dynprog")){
        long startTime3 = System.currentTimeMillis();
        long solutiondynprog = solver.dynprog(maxsubarray3, n);
        System.out.println("__________DYNAMIC PROGRAMMING________\nThe sum of the array is " + solutiondynprog);
        long endTime3 = System.currentTimeMillis() - startTime3;
        System.out.println(endTime3);
        //}
    }

}