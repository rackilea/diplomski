public class EveryInteger {

    public static void main(String[] args) {
        int a1[] = {1, 7, 3, 4};
         int a2[] = new int[4];
          for(int i =0; i<a1.length; i++){
            int sum = 1;

            for(int j =0; j<a1.length; j++){
                if(a1[i]==a1[j]){
                    continue;
                }
                sum *= a1[j];
            }
            a2[i] = sum;
            System.out.println(a2[i]);
          }
    }
}