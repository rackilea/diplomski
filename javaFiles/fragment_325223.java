public class sq {


    public static void main(String args[]){
        long array[] = new long [100];

        array[0] = 0;
        array[1] = 1;

        for(int i = 2; i < 100; i++){
            array[i] = array[i-1] + array[i-2];
        }

        for(int i = 0; i < 100; ++i ){
            System.out.print(array[i] + " ");
        }
    }
}