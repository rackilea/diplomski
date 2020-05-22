public static void main(String args[]) throws IOException 
{
   String command, temp;
   ServerSocket s1 = new ServerSocket(40021);
    while(true)
    {
      Socket ss = s1.accept();
      Scanner sc = new Scanner(ss.getInputStream());
      while(sc.hasNextLine())
      {
        command = sc.nextLine();
        temp = command + " Dat dus";
        PrintStream p = new PrintStream(ss.getOutputStream());
        p.println(temp);
      }
   }
 }