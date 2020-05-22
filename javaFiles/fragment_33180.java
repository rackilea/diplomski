// try to replace this method becz here you do two mistake here.

public static int getNumber(){
//1.you have gave int array length "numbers" at declaration time.
        int[] numbers = new int[MyActivity.numbers.length] ;

        for( int i = 0 ; i < MyActivity.numbers.length ; i++ ){
            if(!MyActivity.numbers[i].equals("")){
                //2.you have set value of "numbers" array at each index.
                numbers[i] = Integer.parseInt(MyActivity.numbers[i]);
            }
        }

        Random r = new Random();
        int i = r.nextInt(numbers.length-0) + 0;

        for( int u = 0 ; u < MyActivity.numbers.length  ; u++  ){

            if ( MyActivity.numbers[u].equals(numbers[i])){
                MyActivity.numbers[u] = "" ;
            }

       }

return numbers[i] ;
}