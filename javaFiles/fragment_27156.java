public static void moveToTail(LinkedList<?> list,int startElement, int endElement) {
    if (startElement <0 )
        return ;
    if (endElement < startElement)
        return;
    if (endElement >= list.size())
        return;
    for(int i = startElement ; i < endElement ; ++i) {
         //yeah it has to be startElement and not i
         list.addLast(list.remove(startElement));
    }
}