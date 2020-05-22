int input = yourInput;
final int base = 10; //could be anything
final ArrayList<Integer> result = new ArrayList<>();
while(input != 0) {
    result.add(input % (base));
    input = input / base;
}