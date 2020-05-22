public static void main(String[] args) {
    int newArray[] = new int[10];

    for(int i = 0; i < newArray.length ; i ++){
        newArray[i] = i;
    }

    /* DISPLAY YOUR ARRAY */

    for(int integer : newArray){
        System.out.println(integer);
    }
}