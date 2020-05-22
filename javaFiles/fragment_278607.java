@Override
public boolean equals(Object obj) {

    if (obj == null)
        return false;
    SingleLinkedList<Integer> listToCompare = (SingleLinkedList<Integer>) obj;
    SingleLinkedList<Integer> thisList = this;
    while (listToCompare != null && thisList != null) {
        if (!listToCompare.getData().equals(thisList.getData()))
            return false;

        listToCompare = listToCompare.getNext();
        thisList = thisList.getNext();
    }
    if (listToCompare == null && thisList == null)
        return true;

    return false;

}