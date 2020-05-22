public class W07problem07 {

public static int getRandomIntRange(int min, int max) {
  int x = (int) (Math.random() * ((max - min))) + min;
  return x;
}

public static void main(String[] args) {
  int count = 1;
  int[] A1 = new int[10];
  int[] A2 = new int[10];

  //loop for storing 1-10 int number withing  A1[].
  for (int k = 0; k < A1.length; k++) {
      A1[k] = count;
      count++;
  }

  int j=0;
  while (j < A1.length) {
      int ranNum = getRandomIntRange(1, A1.length+1);
      if(!numAlreadyExists(A2,ranNum)) {
          A2[j++] = ranNum;
      }
  }



  for (int k = 0; k < A2.length; k++) {
      System.out.println(A2[k]);
  }
}
public static boolean numAlreadyExists(int[] array, int element) {
  for(int i=0;i<array.length; i++) {
    if(element == array[i]) {
     return true;
    }
   }
  return false;
 }
}