public class Picture {

  private static final int[][] PICTURE = new int[][] { 
    { 0, 1, 1, 1, 1, 0, 0, 0, 0, 0, 1 },
    { 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0 },
    { 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
    { 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1 },
    { 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 0 },
    { 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0 }, 
    { 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0 }
  };

  private boolean[][] visited;
  private int[][] picture;

  public Picture(int[][] picture) {
    this.picture = picture;
  }

  public int countBlobs() {
    if (picture.length == 0) {
      return 0;
    }
    int blobCount = 0;
    visited = new boolean[picture.length][picture[0].length];
    for (int i = 0; i < picture.length; i++) {
      for (int j = 0; j < picture[i].length; j++) {
        if (!visited[i][j]) {
          if (!isWhite(i, j)) {
            countHelper(i, j);
            blobCount++;
          }
          visited[i][j] = true;
        }
      }
    }
    return blobCount;
  }

  private void countHelper(int i, int j) {
    visited[i][j] = true;
    if (!isWhite(i, j)) {
      for (int deltaI = -1; deltaI <= 1; deltaI++) {
        for (int deltaJ = -1; deltaJ <= 1; deltaJ++) {
          int adjI = i + deltaI;
          int adjJ = j + deltaJ;
          if (inBounds(adjI, adjJ) && !visited[adjI][adjJ]) {
            countHelper(adjI, adjJ);
          }
        }
      }
    }
  }

  private boolean inBounds(int i, int j) {
    return i >= 0 && j >= 0 && i < picture.length && j < picture[i].length;
  }

  private boolean isWhite(int i, int j) {
    return inBounds(i, j) && picture[i][j] == 0;
  }

  public static void main(String[] args) {
    System.out.println(new Picture(PICTURE).countBlobs());
  }
}