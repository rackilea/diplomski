BufferedImage bf = //Assuming you have a buffered image
int[][] R = new int[bf.getWidth()][bf.getHeight()];
int[][] G = //Same as for R
int[][] B = //Same as for R

for(int r = 0; r < bf.getWidth(); r++)
{
     for(int c = 0; c < bf.getHeight() c++)
     {
           //Uses the Java color class to do the conversion from int to RGB
           Color temp = new Color(bf.getRGB(r, c));
           R[r][c] = temp.getRed();
           G[r][c] = temp.getGreen();
           B[r][c] = temp.getBlue();
     }
}