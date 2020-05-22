while (sc.hasNext()) {
    int numberToFind = Integer.parseInt(sc.next("\\(\\d+\\)").replaceAll("[()]", ""));

    int[] arrayToFindIn  = Arrays.stream(sc.nextLine().split("[ ,{}]"))
                                        .filter(x->!x.isEmpty())
                                        .mapToInt(Integer::parseInt)
                                        .toArray();

    // Apply your binary search ! Craft it by yourself or use a std one like below :
    // int positionInArray = Arrays.binarySearch(arrayToFindIn, numberToFind);
}