public class CalculateScore {

  public static void main(String[] args) {
    float currentScore = 6.1123; //you can initialize with any desired value
    int currentCount = 12;//you can initialize with any desired value

    float newValue = 0;
    Scanner scanner = new Scanner( System.in );     

    do{
        System.out.println("Enter your new value. Enter 0 or negative to exit.");
        newValue = scanner.nextFloat();
        if(newValue>0){
            currentScore = (currentScore*currentCount+newValue)/(++currentCount);
            System.out.println("Your new score is "+currentScore);
        }else{
            System.out.println("Program is exiting");
        }

    }while(newValue >0);
   }
  }