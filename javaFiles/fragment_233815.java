public class AssignmentArrays {
    static int[] data = new int[6];
    static Scanner seg;

    public static void getIDs() {
        int[] data = new int[6];
        data[0] = 0;
        data[1] = 0;
        data[2] = 0;
        data[3] = 0;
        data[4] = 0;
        data[5] = 0;

        /* Segment values */

        System.out.println("Enter cost for segment 0:");
        data[0] = seg.nextInt();

        System.out.println("Enter cost for segment 1:");
        data[1] = seg.nextInt();

        System.out.println("Enter cost for segment 2::");
        data[2] = seg.nextInt();

        System.out.println("Enter cost for segment 3:");
        data[3] = seg.nextInt();

        System.out.println("Enter cost for segment 4:");
        data[4] = seg.nextInt();

        System.out.println("Enter cost for segment 5:");
        data[5] = seg.nextInt();

    }

    public static void pathCalc() {
        int pathCost;

        System.out.println("Enter ID of segment 0 of path:");
        int node1value = seg.nextInt();

        System.out.println("Enter ID of segment 1 of path:");
        int node2value = seg.nextInt();

        System.out.println("Enter ID of segment 2 of path:");
        int node3value = seg.nextInt();

        /* Path cost calculation */

        pathCost = data[node1value] + data[node2value] + data[node3value];
        System.out.println("The cost of the trip is: $" + pathCost);
    }

    public static void main(String[] args) {
        seg = new Scanner(System.in);
        getIDs();
        pathCalc();
        System.out.println("Enter 0 to exit or any other number"
                + " to evaluate another path:");
        int choice;
        choice = seg.nextInt();

        while (choice != 0) {
            getIDs();
            pathCalc();
            System.out.println("Enter 0 to exit or any other number"
                    + " to evaluate another path:");
            choice = seg.nextInt();
        }
        seg.close();
    }
}