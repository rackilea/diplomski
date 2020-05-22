for (int k = 0; k < triplet[i][j].length; k++) 
{
    triplet[i][j][k] = k+1;

    //Don't put the comma after last digit.
    if(k==triplet[i][j].length-1) {
        System.out.print(triplet[i][j][k] );
    }else {
        System.out.print(triplet[i][j][k] + "," + "");
    }

}