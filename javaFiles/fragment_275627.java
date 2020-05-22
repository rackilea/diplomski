public static void main(String args[])
     {  
      Environment clips;

      clips = new Environment();
            clips.build("(deffacts happyFacts " +
                  "  (happy Peter)" +
                  "  (happy Alex)" +
                  "  (happy Mary))");

      clips.reset();            

      clips.eval("(facts)");
      MultifieldValue mv = (MultifieldValue) clips.eval("(find-all-facts ((?f happy)) TRUE)");
      FactAddressValue fact = (FactAddressValue) mv.multifieldValue().get(0);

      try
        {
         System.out.println("Slot value is " + fact.getFactSlot(null));
        }
      catch (Exception e)
        {
         e.printStackTrace();
        }
     }