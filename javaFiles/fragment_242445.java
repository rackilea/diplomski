public String randomMap(){
   Map<String,String> test=new TreeMap<String, String>();
   Object[] arraySet=test.keySet().toArray();
   Random randomGenerator = new Random();
   long range = (long) 1- (long) arraySet.length;

   long fraction = (long) (range * randomGenerator.nextDouble());
   int randomNumber = (int) (fraction + 1);
   String setToGet=(String)arraySet[Math.abs(randomNumber)] ;
   String x=test.get(setToGet);
   return (setToGet+x);
}