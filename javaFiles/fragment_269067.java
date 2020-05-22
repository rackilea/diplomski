public class Matrix {
    public static void main(String[] args) {
        char[][] arr = {
                { 'a', 'v', 'i', 'o', 'n', 'l' }, 
                { 't', 'o', 't', 'o', 'l', 'l' },
                { 'm', 'a', 'r', 'c', 'o', 'e' }, 
                { 's', 'a', 'g', 'r', 'c', 'i' }, 
                { 'o', 'e', 'n', 'z', 'o', 'g' },
                { 's', 't', 'r', 'a', 'r', 'u' } };
        for (int n = -arr.length; n <= arr.length; n++) {
            for(int i = 0; i < arr.length; i++){
                if((i-n>=0)&&(i-n<arr.length)){
                    System.out.print(arr[i][i-n]);
                }
            }
            System.out.println();
        }
    }
}