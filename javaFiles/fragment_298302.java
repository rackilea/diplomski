public static ArrayList<Integer>[] checkerOddEven (int[] numbers){
    ArrayList<Integer> list[]; // I create an Array of ArrayLists
    list = new ArrayList[2]; // I allocate memory for two ArrayLists inside that array. It's important to note that without this, trying to do list[0]=new ArrayList<>(); would have crashed, because there's no list[] yet.
    list[0] = new ArrayList<>();list[1] = new ArrayList<>(); //I create the ArrayList instances by calling their constructor

    for(int number : numbers){
        if(oddEven(number)){
            list[0].add(number);
        }
        else list[1].add(number);
    }

    return list;
}

public static void main(String[] args) {
    Main main = new Main();
    ArrayList<Integer>[] listOfNumbers = (checkerOddEven(main.numbers));
    System.out.print("Odds: "); for(int i=0;i<listOfNumbers[0].size();i++) System.out.print(listOfNumbers[0].get(i)+" ");
    System.out.println(); 
    System.out.print("Even: "); for(int i=0;i<listOfNumbers[1].size();i++) System.out.print(listOfNumbers[1].get(i)+" ");
}