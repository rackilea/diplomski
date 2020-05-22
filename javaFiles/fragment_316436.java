public static Integer[][] getRandomNumbersArray(int base) 
{
    Random rng = new Random();
    int numberOfElements = base * base;

    // Let's use a list so we access by index
    List<Integer> generatedNumbers = new ArrayList<>();

    for (int i = 0; i < numberOfElements; i++) 
    {
        // Generate our random number
        Integer next = rng.nextInt(numberOfElements) ;

        // Check if the number is already added
        if (!generatedNumbers.contains(next)) {
            generatedNumbers.add(next);
        }
        // Number was a duplicate, redo loop cycle
        else i--;
    }
    // Create our board array here
    Integer[][] array = new Integer[base][base];

    // Index used to access the list
    int i1 = 0;

    for (int i2 = 0; i2 < base; i2++) 
    {
        // Populate board row
        for (int i3 = 0; i3 < base; i3++, i1++) {
            array[i2][i3] = generatedNumbers.get(i1);
        }
    }
    return array;
}

public static void main(String[] args)
{
    Integer[][] array = getRandomNumbersArray(4);

    System.out.println("Here is how our board looks like:");
    for (int i = 0; i < array.length; i++) {
        System.out.println(Arrays.toString(array[i]));
    }
}