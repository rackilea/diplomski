public static void main(String[] args) {
     Scanner scan = new Scanner(System.in);
     int i = 0, lines = 1;
     int[] items = new int[100];
     int total = 0;
     System.out.println("Enter the items with its price");

     while(true){
          String InputTxt = scan.nextLine();
          if (InputTxt.equals("stop"))
              break;
          else{           
              try{
                 items[i] = Integer.parseInt(InputTxt);
                 i++;
              }catch(Exception e){
                 System.out.println("Please enter a number");
              }
          }

     } 

 }