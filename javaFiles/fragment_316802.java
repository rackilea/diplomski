class Utility{

  private static int sharedValue; //something like counter of how many times nameTo() is called

  public static String nameTo(boolean b){
     //logic

     sharedValue++; //this will not be thread safe as it is shared state and being updated  in parallel

  }
}