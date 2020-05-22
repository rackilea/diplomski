for(int j=0; j< array.length; j++) {
    for(int k=j+1; k< array.length; k++) {
        if(array[j] == array[k]) {
            continue;
        }
        System.out.print(array[j] + " ");
        j = k;
    }
}
System.out.print(array[array.length-1] + " ");