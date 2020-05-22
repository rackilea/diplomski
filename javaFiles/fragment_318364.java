public static void main(String args[]) throws IOException
{

    BufferedReader in = new BufferedReader(new FileReader("In0204.txt"));
    int n = Integer.parseInt(in.readLine());

    zapis = new PrintWriter("Out0204.txt");
    int i;
    int m[]= new int[n];
    int a[][] = new int[n][n];
    for (i=0; i<n; i++)
    {
        m[i] = 0;
    }


    String line;
    for (int curLine = 0; (line = in.readLine()) != null; curLine ++) {
        StringTokenizer tok = new StringTokenizer(line);
        while (tok.hasMoreElements())
            a[curLine][Integer.parseInt(tok.nextToken()) - 1] = 1;
    }
    in.close();
    System.out.println("\nKolejnosc odwiedzanych wierzcholkow : \n");
    for (i=0; i<n; i++)
        if (m[i]==0)
        {
            przeszukiwanie_w_glab(a,m,i,n);
        }
    zapis.close();
}