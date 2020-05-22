package msm;
public class DLLBootstrapper {

     static {
      System.loadLibrary("sharedlib");
     }

     public static void main(String args[]) {
      System.out.println("Loaded");
     }

    }