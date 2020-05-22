public int[] generateRandomPositions(){
    int[] positions = new int[3];
    Random r = new Random();
    int i1 = r.nextInt(8);
    positions[0] = i1;
    step1:
    do{
        i1 = r.nextInt(8);
    }while(positions[0] == i1);
    positions[1] = i1;
    do{
        i1 = r.nextInt(8);
    }
    while(positions[1] == i1  || positions[0] == i1);
    positions[2] = i1;
    return positions;
}