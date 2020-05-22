public class SimplepointsDistance {

public static void main(String[] args) {
    double[] xCoordArray = new double[10];
    double[] yCoordArray = new double[10];
    double[] zCoordArray = new double[10];

    for (int i = 0; i < 10; i++) {
        xCoordArray[i] = (int)(Math.random() * 10);
        yCoordArray[i] = (int)(Math.random() * 10);
        zCoordArray[i] = (int)(Math.random() * 10);
    }


    int[] xyDistance = new int[10];
    for(int i=0;i<10;i++){
        xyDistance[i] = (int) Math.abs(xCoordArray[i] - yCoordArray[i]);
    }

    int[] xzDistance = new int[10];
    for(int i=0;i<10;i++){
        xzDistance[i] = (int) Math.abs(xCoordArray[i] - zCoordArray[i]);
    }

    int[] yzDistance = new int[10];
    for(int i=0;i<10;i++){
        yzDistance[i] = (int) Math.abs(yCoordArray[i] - zCoordArray[i]);
    }

    for (int i=0;i<10;i++){
        int maxDistance = xyDistance[i];
        int maxDistancePair = 1; //understand 1 means xy, 2 means xz, 3 means yz;

        if (xzDistance[i] > maxDistance) {
            maxDistance = xzDistance[i];
            maxDistancePair = 2;
        }

        if (yzDistance[i] > maxDistance) {
            maxDistance = yzDistance[i];
            maxDistancePair = 3;
        }

        switch (maxDistancePair) {
        case 1: 
            System.out.println("Greatest distance in set " + i + " is " + maxDistance + " between x and y");
            break;
        case 2: 
            System.out.println("Greatest distance in set " + i + " is " + maxDistance + " between x and z");
            break;
        case 3: 
            System.out.println("Greatest distance in set " + i + " is " + maxDistance + " between y and z");
            break;

        }



    }

}