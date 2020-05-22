import java.util.Random;
import java.util.Scanner;

public class Node{

    public int value;

    public Node higher = null;
    public Node lower = null;

    //Making it a public static object was just easier for the test
    public static int addIndex = 0;
    public static int numOps = 0;

    public Node(int i){
        value = i;
    }

    public void addToNode(int i){
        if(i>=value)
            if(higher != null) higher.addToNode(i);
            else higher = new Node(i);
        else
            if(lower != null) lower.addToNode(i);
            else lower = new Node(i);
        numOps++;
    }

    public static void nodeSortTest(int[] nums){
        if(nums.length<2)
            return;
        Node keyNode = new Node(nums[0]);
        for(int i = 1; i < nums.length; i++)
            keyNode.addToNode(nums[i]);
        Node.addIndex = 0;
        keyNode.addTo(nums);
    }

    public void addTo(int[] nums){
        if(lower != null) lower.addTo(nums);
        nums[addIndex] = value;
        addIndex++;
        if(higher != null) higher.addTo(nums);
        numOps++;
    }
    public static void main(String args[]) {
        Random r = new Random();
        System.out.print("Enter size of array: ");
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        int [] arrayToSort = new int [n];
        for (int i=0; i < n; i++) {
            arrayToSort[i] = r.nextInt(100000);
        }
        for (int i: arrayToSort) {
            System.out.print(i+",");
        }
        System.out.println();
        nodeSortTest(arrayToSort);
        for (int i:arrayToSort) {
            System.out.print(i+",");
        }
        System.out.println();
        System.out.println("\n\n\nn=" + arrayToSort.length + ", numOps=" + numOps);
        double log2n = Math.log(n)/Math.log(2);
        System.out.println("\n\nValue of n=" + n + " times log2n=" + log2n + " = " + n*log2n);
        scan.close();
    }
}