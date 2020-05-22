public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);
      int sum=0;
      for(int i=0;i<4;i++){
          System.out.println("ENter Number"+(i+1));
          sum += sc.nextInt();
      }
     System.out.println("the Sum is "+sum);
       sc.close();
    }