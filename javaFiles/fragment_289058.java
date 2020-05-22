outerloop:
for (int j = 0; j < array.length; j++) {
    for(int k = 0; k < j; k++) {
        if(array[j] == array[k]) {
                continue outerloop;
        }
    }
    System.out.print(array[j] + " ");
}