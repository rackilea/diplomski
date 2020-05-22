public static void bufferWithLeadingZeroes(List<Integer>[] theLists, int maxLength){
    for (int i=0; i<10; i++){
        int howManyToAdd = maxLength - theLists[i].size();
        for (int j=0; j<howManyToAdd; j++){
            theLists[i].add(0,0);
        }
    }
    theLists[10].add(0,0);
}