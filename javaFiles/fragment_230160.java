public void run(){
 long sumCompare = 0;
 long sumSave = 0
 for(int i = startIndex; i<= lastIndex; i++) {
    for(int j=0;j<15000;j++){
        final long compareStart = System.currentTimeMillis();
        compare.compareIris(bloblist.get(i),bloblist.get(j));
        score= compare.getScore();
        final long compareEnd = System.currentTimeMillis();
        compareSum += (compareEnd - compareStart);
        //save result to Excel using Apache POI
        ...
        ...
        final long saveEnd = System.currentTimeMillis();
        saveSum += (saveEnd - compareEnd);
        }
 }
System.out.println(String.format("Compare: %d; Save: %d", sumCompare, sumSave);
}