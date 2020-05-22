public static void accept_name (String[] name, int[] r) throws IOException
{
   InputStreamReader isr = new InputStreamReader(System.in);
   BufferedReader ab = new BufferedReader(isr);

    r = new int[40];
    name = new String[40];

    for(int i=0;i<40;i++)
    {
        System.out.println("Enter the name of students");
        name[i] = ab.readLine();
    }             
}