public int samletFravaer(int[][] fravaer, int elevNr) {
    int samletFravaer = 0;
    for(int i1 = 0 ; i1 < fravaer[elevNr].length ; i1++)
    {
        samletFravaer += fravaer[elevNr][i1];
    }

    System.out.println( samletFravaer );
    return samletFravaer;
}