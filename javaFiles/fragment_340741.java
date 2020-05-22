public void printList(List<Object> a)
{
    for (Iterator<Object> it = a.iterator(); it.hasNext();) {
        Object item = it.next();
        if (item instanceof List) printList((List<Object>) item);
        else System.out.print(item + ", ");
    }
}