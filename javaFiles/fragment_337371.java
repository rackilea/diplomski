private static int printFirstIndexOfRepeated(int[] values,int number) {
    for(int i = 0; i < values.length; i++){
        if(values[i] == number){
            //System.out.println("The first index of " + number + " is " + i);
            return i;
        }
    }
    //System.out.println(number + " is not a member of the array.");
    return -1;
}