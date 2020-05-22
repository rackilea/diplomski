//Declaring an ArrayList
ArrayList<String> stringArrayList = new ArrayList<String>();

//add to the end of the list
stringArrayList.add("foo");

//add to the beggining of the list
stringArrayList.add(0, "food");

//remove an element at a spesific index
stringArrayList.remove(4);

//get the size of the list
stringArrayList.size();

//clear the whole list
stringArrayList.clear();

//copy to a new ArrayList
ArrayList<String> myNewArrayList = new ArrayList<>(oldArrayList);

//to reverse
Collections.reverse(stringArrayList);

//something that could work as "pop" could be
stringArrayList.remove(stringArrayList.size() - 1);