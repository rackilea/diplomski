public static void main(String args[]) throws IOException
{ 
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    System.out.print("Enter: ");
    char ch = (char) br.read();
    System.out.print("Entered is: " + ch);
}