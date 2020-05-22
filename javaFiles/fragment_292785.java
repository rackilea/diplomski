public LetterInventory add(LetterInventory other){
    LetterInventory temp = new LetterInventory();
    temp.array.addAll(array);
    temp.size = temp.array.size();
    return temp;
}