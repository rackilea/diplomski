public static void main(String[] args) {

    int rock = 0, paper = 1, scissors = 2;
    Random rand = new Random();
    int random_try = rand.nextInt(3);

    if(random_try == 0){
      System.out.println("Random choice was Rock");
    }
    else if(random_try == 1){
      System.out.println("Random choice was Paper");
    }
    else if(random_try == 2){
      System.out.println("Random choice was Scissors");
    }

  }