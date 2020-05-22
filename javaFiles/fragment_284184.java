public static void main(String[] args)
{
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    HashSet<BigInteger> hs = new HashSet<BigInteger>();
    for (int i = 0; i < n; i++) {
       String str = in.next();
       BigInteger bi = new BigInteger(str);
       hs.add(bi);
   }
   Iterator<BigInteger> itr = hs.iterator();
   while (itr.hasNext())
     System.out.println(itr.next());
   in.close();
}