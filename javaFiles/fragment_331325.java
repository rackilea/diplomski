static int a ;
static {
    String x = System.getProperty("abc");
    try{  
       a = Integer.parseInt(x);
    }
    catch (Exception e){
       throw new IllegalArgumentException
          ("missing or invalid system property 'abc': "+x);
    }
}