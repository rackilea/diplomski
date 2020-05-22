if (searchingValue == list.get(list.size() - 1 - decreasingCounter)) {
    System.out.print(searchingValue + "   FOUND at position" + (list.size() - 1 - decreasingCounter) + "\n");
    list.remove(list.size() - 1 - decreasingCounter);

    deleteDuplicateValues(list, decreasingCounter, searchingVal + 1, outsideCounter + 1); <<-- HERE!
}