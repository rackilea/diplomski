int count = 0;
//...
while(count <= expoBdd.getNumberOfRows()){
    Exposition expoFromDb = expoBdd.getExpositionWithId(count);
    listeExposition.add(expoFromDb);
    count++;
}