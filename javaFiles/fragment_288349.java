public class Pool {

    private static double r = 20;

    private void setupBalls() {
        List<Ball> balls = new ArrayList<>();
        int ballId = 0;

        // for each row
        for(int rowNumber = 0; rowNumber<5; rowNumber++) {
            System.out.print("Row "+rowNumber + ": ");

            // get the Xs of the balls in that row, 
            // and create a ball for each
            double y = rowY(rowNumber);
            for(double x : rowXs(rowNumber)) {
                Ball ball = new Ball(ballId, x, y);
                balls.add(ball);
                System.out.print(ball + " ");
                ballId++;
            }

            System.out.println();
        }
    }

    // Returns the Y of a given row 
    private double rowY(int rowNumber) {
        return rowNumber * (Math.sqrt(5) * r);
    }

   // Returns the list of the Xs for the balls on the given row 
   private double[] rowXs(int rowNumber) {
        switch (rowNumber) {
            case 0: return new double[] {0};
            case 1: return new double[] {-r, r};
            case 2: return new double[] {-2*r, 0, 2*r};
            case 3: return new double[] {-3*r, -r, r, 3*r};
            case 4: return new double[] {-4*r, -2*r, 0, 2*r, 4*r};
            default: throw new IllegalArgumentException("no more than 5 rows");
        }
    }

}