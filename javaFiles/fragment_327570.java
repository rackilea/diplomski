String[][] arr = {{"5.0","a"},{"3.0","b"},{"2.0","c"},{"4.0","d"},{"1.0","e"}};

// Sort elements in range 2 ... arr.length
List<String[]> sublist = Arrays.asList(arr).subList(2, arr.length);
Collections.sort(sublist, new Comparator<String[]>() {
    @Override
    public int compare(String[] a1, String[] a2) {
        return Float.valueOf(a1[0]).compareTo(Float.valueOf(a2[0]));
    }
});


// Prints [[5.0, a], [3.0, b], [1.0, e], [2.0, c], [4.0, d]]
//         ^^^^^^^^^^^^^^^^^^   ^^^^^^^^^^^^^^^^^^^^^^^^^^^
//            not affected         sorted by first index
System.out.println(Arrays.deepToString(arr));