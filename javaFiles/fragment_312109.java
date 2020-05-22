class Utility
{
    private static int sleepTime = 20;
    public static void setSleepTime( int time ){ sleepTime = time; }

    public static void waitFor(){
       try {
          Thread.sleep(sleepTime * 1000L);
       } catch (Exception e) {
          System.out.println(e.toString());
       }
    }
}