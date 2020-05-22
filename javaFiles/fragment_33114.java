int listSize = 0;
CalendarLinkedList currentList = firstList;
while (currentList.next != null)
{
    currentList = currentList.next;
    listSize++;
}
CalendarLinkedList newList = new CalendarLinkedList(todayDate, listSize + 1);
newList.setPrev(currentList);
currentList.setNext(newList);