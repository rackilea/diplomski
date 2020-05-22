public static void main(String[] args) throws IOException 
{
    String inp = "first.txt";
    String two = "second.txt";
    BufferedReader br = new BufferedReader(new FileReader(inp));
    BufferedReader br2 = new BufferedReader(new FileReader(two));

    String st,rt="";
    BufferedWriter bw = new BufferedWriter(new FileWriter("location"));
    boolean isCompleted = false;
    while( !isCompleted)
    {
        st=br.readLine() ;
        bw.write(st==null?"":st);
        bw.newLine();
        rt=br2.readLine();
        bw.write(rt==null?"":rt);
        bw.newLine();

        isCompleted = (st==null && rt == null) ? true : false ;

    }
    bw.close();
}