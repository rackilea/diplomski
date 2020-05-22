ArrayList<LinkedList<String>> listOfLists = new ArrayList<LinkedList<String>>();
for(int i = 0; i < 10; i++)
{
    LinkedList<String> list = new LinkedList();
    listOfLists.add(list);
    // do stuff to the list...
}
// access
LinkedList<String> thirdList = listOfLists.get(2); // index 2 = third entry