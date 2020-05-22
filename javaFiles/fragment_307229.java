public class main {
    public static void main(String[] args) {
        String [] arr = {"Barcelona","Watford","Manchester United","Real Mandrid","Barcelona","Manchester United","city"};
        int L = arr.length;

        for (int i = 0; i < L; i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();     

        for (int i = 0; i < L - 1 ; i++) {
            for (int j = i + 1; j < L; j++) {
                if(arr[i].equals(arr[j])){
                    arr[j] = arr[L -1];
                    L--;
                    j--;
                }
            }
        }

        for (int i = 0; i < L; i++){
            System.out.print(" " + arr[i]);
        }
        System.out.println();   
    }
}