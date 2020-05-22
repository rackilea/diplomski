public static void insertionSort(ArrayList<Card> Array) {

    int i,

    j;

    for (i = 1; i < Array.size(); i++) {
        Card key = new Card(0, "","");
        key.value = Array.get(i).value;
        key.suit = Array.get(i).suit;
        key.faceValue = Array.get(i).faceValue;
        j = i;
        while((j > 0) && (Array.get(j - 1).value > key.value)) {
            Array.set(j,Array.get(j - 1));
            j--;
        }
        Array.set(j,key);
    }


}