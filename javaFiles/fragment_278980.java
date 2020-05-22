public static void printRecursiveList(List myList) {
    for (Object obj : myList) {
        if (obj instanceof List) {
            printRecursiveList((List) obj); // call itself again since its a list
        } else {
            System.out.println(obj);
        }
    }
}