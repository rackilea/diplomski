for ( int i = 0; i <= 4;i++){
    System.out.println ( "Input a number between 1 and 25 inclusive: " );
    temp1 = reader.nextInt();

    boolean repeated = false;
    for(int j = 0; j < i; j++) {
        if(finalarray[j] == temp1) {
            // the number is already entered.
            repeated = true;
            break;
        }
    }

    if(repeated)
        break;

    // number is not entered before
    finalarray[i] = temp1;
}