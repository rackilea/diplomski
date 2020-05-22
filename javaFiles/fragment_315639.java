public static void main(String[] arg) {
        int[] array = { 0, 1, 2, 2, 3, 3, 4, 4, 5, 6, 8, 8, 9, 9, 9, 10, 11, 12, 13, 15, 16, 20, 21, 22, 22, 23, 24, 24, 26,
                27, 27, 28, 30 };

        MyLinearSearch linSearch = new MyLinearSearch();
        for (int i = 0 ; i < array.length ; i++) {
            System.out.println("Number " + array[i] + " " + " Linear Search Index At "
                    + linSearch.linearSearch(array, array[i]));
        }
    }