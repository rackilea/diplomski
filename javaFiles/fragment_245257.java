class allPerfect {
  public static void main(String args[]){
    int sum;
    System.out.println("All perfect numbers between 1 and 500 are:");
    for(int j = 1; j!=501; j++){
      sum = 0;     //**You should reset the sum at the start of the inner loop.**
      for(int i = 1; i < j; i++ ){
        if(j % i == 0) {
          sum = sum + i;
        }
      }      
      if(sum == j) {              //------ statement-1
        System.out.println(j);
      }
    }
  }
}