public class PointsDistance {

    public static void main(String[] args) {

        double[] xCoordArray = new double[10];
        double[] yCoordArray = new double[10];
        double[] zCoordArray = new double[10];

        for (int i = 0; i < 10; i++) {
            xCoordArray[i] = (int)(Math.random() * 10);
            yCoordArray[i] = (int)(Math.random() * 10);
            zCoordArray[i] = (int)(Math.random() * 10);
        }


        double distance[] = new double[45];
        int setCounter = 0;
        double maxDistance = 0;
        int maxI = -1;
        int maxJ = -1;

        for (int i=0 ;i<9;i++){
            for ( int j=i+1;j<10;j++){
                distance[setCounter] = Math.sqrt ( Math.pow (xCoordArray[i] - xCoordArray[j], 2) + Math.pow (yCoordArray[i] - yCoordArray[j], 2) + Math.pow (zCoordArray[i] - zCoordArray[j], 2));

                System.out.println("Testing " + i + " and " + j + " with distance " + distance[setCounter]);
                if (distance[setCounter] > maxDistance) {
                    maxDistance = distance[setCounter ++];
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        System.out.println("Maximum distance is " + maxDistance);
        System.out.println("Between point " + maxI + ": " + xCoordArray[maxI] + ", " + yCoordArray[maxI] + ", " +  zCoordArray[maxI]);
        System.out.println("And "  + maxJ + ": " + xCoordArray[maxJ] + ", " + yCoordArray[maxJ] + ", " +  zCoordArray[maxJ]);
    }
}