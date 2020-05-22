public static void main(String args[])
{
    // Put all the code in one try block
    try {
        InputStreamReader in=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(in);
        int t=Integer.parseInt(br.readLine());
        int[] n=new int[t];
        for(int i=0;i<n.length;i++)
        {
            n[i]=Integer.parseInt(br.readLine());
        }
        for(int i=0;i<n.length;i++)
        {
            int x=n[i];
            BigInteger p = new BigInteger(Integer.toString(x));
            p=smallfac.fac(p);
            System.out.println(p);
        }
    }catch(IOException e){
        // Report the error here
    }
}