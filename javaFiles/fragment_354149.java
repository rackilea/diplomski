static List<Integer> numbers;

public static void main(String[] args) throws Exception {

    numbers = new ArrayList<Integer>() {
        {
            add(3);
            add(4);
            add(6);
            add(1);
            add(9);
        }

    };
    int x = 1;
    int result = searchNum(x, 0);
    if (result != -1) {
        System.out.println("There is x in the array, and the index is: " + result);
        System.out.println("There is x in the array, and the Position is: " + (result + 1));
    } else
        System.out.println("X is not found in List");
}

private static int searchNum(int x, Integer index) {

    if (index == numbers.size())
        return -1;
    if (!(numbers.get(index) == x)) {
        return searchNum(x, index + 1);
    }

    return index;
}