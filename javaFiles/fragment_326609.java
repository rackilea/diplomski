public class City {
    private  int squareSpace[];
    public void getData(){
      Scanner sc = new Scanner(System.in);
      squareSpace[] = new int[10];
      System.out.println("Please enter the square spaces of 10 cities\n");
      for(int i=0;i<10;i++) {
        sqaureSpace[i]=sc.nextInt();
      }
      //sc.close();
    }
    public int findMin(){
      int minValue=squareSpace[0];
      for(int i=1;i<10;i++) {
        if(squareSpace[i]<minValue)
          minValue=squareSpace[i];
    }
 }