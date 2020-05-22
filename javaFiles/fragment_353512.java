int lines = 6;

for (int i = 1; i <= lines; i++){

    for (int j = lines - i + 1; j >= 1; j--){

        System.out.print (j + " ");
    }

    System.out.println();
}