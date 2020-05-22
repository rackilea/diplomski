public class Game{

    public static void main(String[] args){

      for (int dex = 0; dex < 1000; dex++) {
        if (dex % 12 == 0) {
          System.out.println("#: " + dex);
        }
      }
    }
  }