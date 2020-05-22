for (int i = 0; i < size; i++) {
    a[i] = (int)(Math.random()*10);

    for (int j = 0; j < i; j++) {
        if (a[i] == a[j]) {
            a[j] = (int)(Math.random()*10); //What's this! Another random number!
        }
    }   
}