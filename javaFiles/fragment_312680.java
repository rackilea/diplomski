Scanner sc = new Scanner(System.in);
int choice;
while(true){
     System.out.print("Enter key to access functions:");
     choice = sc.nextInt();
     switch(choice) {
     case(1):
          do function:open;
          break;
     case(2):
          do function:close;
          break;
     case(3):
          do function:help;
          break;
     case(4):
          do function:internet;
          break:
     case(5):
          do function:call;
          break;
     case(6):
          do function:go;
          break;
     default:
          System.out.println("Invalid Input");
          break;
     }
}