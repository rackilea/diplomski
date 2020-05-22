public class Test {


  public static void main (String []args) { 


 boolean[] test = new boolean[] {true, false, true, true, false};

 int[] o = longestStreak(test);
 System.out.println ("{"+o[0] + ", " + o[1]+"}");
  }



    public static int[] longestStreak(boolean[] values) {


 int  streak = 0; 
 int max =0;
 int arrsize =0;
 int maxStart = 0;
 int[] r = new int[2];


 for (int i=0; i<values.length; i++) {
   if (values[i]) {   
     streak++;
//     max =streak;
//     arrsize++;
     }

else {
    if (streak > max) {
        max = streak;
        maxStart = 0;
        maxStart = i - streak;
    }
    streak = 0;
   }
 }
 r[0] = max;
 r[1] = maxStart;
 return r;
  }


  }