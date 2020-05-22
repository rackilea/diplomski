List<Integer> list1 = new ArrayList<>();
List<Integer> list2 = new ArrayList<>();
List<Integer> combinedSortedList = new ArrayList<>();
combinedSortedList.addAll(list1);  //Add list1 to our new sorted list
combinedSortedList.addAll(list2); //Add list2 to our new sorted list
Collections.sort(combinedSortedList); //Sorts the list for you