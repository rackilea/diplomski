Random rand; // Global variable

public static int randomItem(Arraylist<Integer> mylist) {
    rand = new Random(); 
    Integer randomInt = lista.get(rand.nextInt(lista.size()));
    return randomInt;
}