public static void bubbleSort(DoubleLinkedList list) //static method used to sort the linked list using bubble sort {
      int i = 0;
      Node currentNode = list.head;
      Node auxNode;
      int foundChange = 1;
      while(foundChange) {
        foundChange = 0;
        for(i=0; i<list.getSize()-1; i++) {
          if (currentNode.getData() > currentNode.getNext().getData()) {
            auxNode.setData(currentNode.getData());
            currentNode.setData(currentNode.getNext.getData());
            currentNode.getNext.setData(auxNode.getData());
            foundChange = 1;
          }
          currentNode = currentNode.getNext();
        }

}