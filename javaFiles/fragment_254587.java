for (int i = 0; i < size; i++) {
    a[i] = (int)(Math.random()*10);//note, this generates numbers from [0,9]

    for (int j = 0; j < i; j++) {
        if (a[i] == a[j]) {
            i--; //if a[i] is a duplicate of a[j], then run the outer loop on i again
            break;
        }
    }  
}