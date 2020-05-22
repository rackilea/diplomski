Vector oldVector;
Vector newVector = new Vector(oldVector.size());

for (int i = 0; i < oldVector.size(); i++){
    // add logic to exclude items from the new vector if you need
    newVector.add(oldVector.get(i));
}