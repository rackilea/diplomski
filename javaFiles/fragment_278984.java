public static void main(String args[])throws IOException
{
    BufferedReader input = new BufferedReader (new InputStreamReader(System.in));
    String s;
    while(true) {
        s = input.readLine();
        if (s.equals("0"))
            break;
        else 
            convert(s);
    }    
}