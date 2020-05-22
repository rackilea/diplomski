public static void printReversed (Elem start)
{
    if (start.next != null) {
        printReversed(start.next); // print the rest of the list in reversed order
    }
    System.out.println(start.data); // print the first element at the end
}