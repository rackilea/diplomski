List<List<Int>> arrayList = new ArrayList(); //Java usually infers type parameters in cases as these
for(int i = 0; i < desiredSize; i++){
    List<Int> listAtI = new ArrayList ();
    for(int j = 0; j < rowLength; j++){
        listAtI.set(j, 0);  //sets the element at j to be  0, notice the values are Int not int, this is dues to Javas generics having to work with classes not simple types, the values are (mostly) automatically boxed/unboxed
    }
    arrayList.set(i, listAtI);
}

arrayList.get(5); //returns the list at index 5
arrayList.get(5).get(5) // returns values from column 5 in row 5