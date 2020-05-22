public class Sequence {
    public static void main(String[] args){

        // 20 8 27 19 10 56 7 12 98
        int[] arr = new int[args.length];

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(args[i]);
        }

        for(int a = 0; a < arr.length; a++){
            for(int b = a + 1; b < arr.length; b++){
                for(int c = b + 1; c < arr.length; c++){
                    if (arr[b] - arr[a] == arr[c] - arr[b]){
                        System.out.println(arr[a] + " " + arr[b] + " " + arr[c]);
                    }
                }
            }
        }
    }
}