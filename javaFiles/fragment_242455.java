List<List<Object>> listOfLists = ...
Object first = listOfList.get(0).get(0);
Object second = listOfList.get(0).get(1);
int count = 0;

for (List<Object> list : listOfList) {
    Object currFirst = list.get(0);
    Object currSecond = list.get(1);
    if (!currFirst.equals(first) || currSecond.equals(second)) {
        first = currFirst;
        second = currSecond;
        count = 0;
    }
    list.add (0, count);
    ++count;
}