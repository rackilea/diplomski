public class Facts
{
   private String[] mFacts;
   private int current = 0;
   public Facts( String[] mFacts )
   {
       this.mFacts = mFacts;
   }

   public boolean hasPrevious()
   {
      return current >= 0;
   }

   public boolean hasNext()
   {
       return current < mFacts.length;
   }

   public String next()
   {
       if( !hasNext() )
       {
            return null;
       }
       String v = mFacts[ current ];
       current++;
       return v;
   }

   public String previous()
   {
       if( !hasPrevious() )
       {
            return null;
       }
       String v = mFacts[ current ];
       current--;
       return v;
   }

   public String random()
   {
        Random randomGenerator = new Random(); 
        int randomNumber = randomGenerator.nextInt(mFacts.length);
        return mFacts[randomNumber];
   }
}