public static void main(String[] args)
 {
  // TODO Auto-generated method stub
  Scanner input = new Scanner(System.in);
  String origPass = "Original";
  String verify = "Verify";

  while(!origPass.equals(verify)){

     System.out.println("Enter your password");
     origPass = input.nextLine();

     System.out.println("Verify your password");
     verify = input.nextLine();
  }
 }