public static void main(String []args){
    int[] number1 = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,2,3,4,5,6,7,8,9};
    int[] number2 = {0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1};

    int carry = 0, sum = 0;

    int[] result = new int[number1.length];
    for (int i = number1.length - 1; i >= 0 ; i--) {
        sum = number1[i] + number2[i] + carry;
        result[i] = sum%10;
        carry = sum/10;
    }
    // [0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 4, 5, 6, 7, 9, 0, 0]                                                                   
    System.out.println(Arrays.toString(result)); 
 }