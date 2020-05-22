public class MyPanel extends JPanel {

    public MyPanel() {
        super();   
    }


    public int[][] getRandomMatrix() {
         int[][] randomMatrix = new int[10][10];
         for (int r = 0; r < randomMatrix.length; r++) {
             for (int c = 0; c < randomMatrix[r].length; c++) {
             randomMatrix[r][c] = (int)(Math.random() * 2);
         }
     }
    return randomMatrix;
   }
}