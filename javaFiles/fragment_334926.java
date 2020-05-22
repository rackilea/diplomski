public static int returnIndex(int[] haystack, int needle) {

    boolean found = false;

    int index = needle;
    System.out.println("\nThe needle is found at index: ");

    for (int i = 0; i < haystack.length; i++) {
        if (haystack[i] == index) {
            System.out.println(i);
            found = true;
        }
    }

    if (found) return index;

    else  {

        System.out.println("Not found.");
        return null;

    }


 }

}