HashSet<Integer> rands = new HashSet<Integer>();
for(int i = 0; i<3; i++)
{
   int rand;
   while (rands.contains(rand = r.nextInt(3)))
       ;
   rands.add(rand);
}