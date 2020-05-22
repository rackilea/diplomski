import java.util.Arrays;
class IntArrayExample {
    public static void main(String[] args) {
      int[] p = new int[10];
      p[0] = 1;
      p[1] = 4;
      p[2] = 7;
      System.out.println(Arrays.toString(p));
      int tail=0;
      for(int i= 0; i < p.length; i++){
        if(p[i]==0){
         tail= i-1;
         System.out.println("tail : " + tail);
         break;
        }
       }
     }
    }