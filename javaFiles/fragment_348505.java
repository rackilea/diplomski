import java.util.Arrays;
import java.util.Scanner;

public class KNN {

    public static void main(String[] args) {
        int[] feature1 = new int[] { 1, 1, 3, 2, 4, 6 };
        int[] feature2 = new int[] { 1, 3, 1, 5, 3, 2 };

        //input hew data's features and k
        Scanner input = new Scanner(System.in);

        System.out.println("Input first feature : ");
        int newFeature1 = input.nextInt();

        System.out.println("Input second feature : ");
        int newFeature2 = input.nextInt();

        System.out.println("Input k : ");
        int k = input.nextInt();

        input.close();

        //count distance between new data and training data
        double[] distances1 = new double[feature1.length];
        double[] distances2 = new double[feature2.length];

        for (int i = 0; i < distances1.length; i++) {
            distances1[i] = Math.pow(newFeature1 - feature1[i], 2);
        }

        for (int i = 0; i < distances2.length; i++) {
            distances2[i] = Math.pow(newFeature2 - feature2[i], 2);
        }

        System.out.println("Distance between first feature and first feature training data: " + Arrays.toString(distances1));
        System.out.println("Distance between second feature and second feature training data: " + Arrays.toString(distances2));

        //sum the array of distance first feature and second feature to get result
        double[] distanceSums = new double[distances1.length];

        for (int i = 0; i < distances1.length; i++) {
            distanceSums[i] = Math.sqrt(distances1[i] + distances2[i]);
        }

        System.out.println("Distance sums: " + Arrays.toString(distanceSums));

        // sort array ascending
        double[] distanceSumsSorted = new double[distanceSums.length];
        System.arraycopy(distanceSums, 0, distanceSumsSorted, 0, distanceSums.length);
        Arrays.sort(distanceSumsSorted);

        System.out.println("Sorted distance sums: " + Arrays.toString(distanceSumsSorted));

        double[] classAMembers = new double[] { distanceSums[0], distanceSums[1], distanceSums[2] };
        double[] classBMembers = new double[] { distanceSums[3], distanceSums[4], distanceSums[5] };

        //determining what class the new data belongs
        int classACounts = 0;
        int classBCounts = 0;

        for (int i = 0; i < k; i++) {
            // check if nearest neighbor belongs to class A
            for (int j = 0; j < classAMembers.length; j++) {
                if (distanceSumsSorted[i] == classAMembers[j]) {
                    classACounts++;
                    break;
                }
            }
            // check if nearest neighbor belongs to class B
            for (int j = 0; j < classBMembers.length; j++) {
                if (distanceSumsSorted[i] == classBMembers[j]) {
                    classBCounts++;
                    break;
                }
            }
        }

        System.out.println("Class A members: " + Arrays.toString(classAMembers));
        System.out.println("Class B members: " + Arrays.toString(classBMembers));

        System.out.println("Counts for class A: " + classACounts);
        System.out.println("Counts for class B: " + classBCounts);

        if (classACounts < classBCounts){
            System.out.println("The Class is B.");
        }
        else {
            System.out.println("The Class is A.");
        }
    }
}