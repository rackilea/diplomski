public static void main(String[] args) {
    int i,j;
    Scanner v=new Scanner(System.in);
    String s=v.next();

    for(i=0;i<s.length();i++)
    {
        String sum = "";
        int k=s.charAt(i);
        if(k>=48 && k<=57)
        {
            for(j=49;j<k;j++)
                sum=sum+s.substring(0,i);
        }
        String c=k-48+"";
        s=s.replaceFirst(c,sum);
    }

    System.out.println(s);
    v.close();

}