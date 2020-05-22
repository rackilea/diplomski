String array[][] = { { "hello", "how" }, { "are", "you" } };
Scanner scan = null;
String str = null;
int len = array.length;
int i = 0;
while (i != 6) { // provide the loop as you require
    scan = new Scanner(new InputStreamReader(System.in));
    str = scan.next();
    try {
        array[len][1] = str; // will try to add to second position. If array is out of index an exception will be thrown
        len++; // won't increase if exception is thrown 
    } catch (ArrayIndexOutOfBoundsException e) {
        array = Arrays.copyOf(array, len + 1); // copying the array
        array[len] = new String[2]; // creating and assigning string array to new row else it will be null
        array[len][0] = str; // adding new string to new array position
    }
    i++;
}
scan.close();

for (String[] strings : array) {
    for (String string : strings) {
        System.out.println(string);
    }
}