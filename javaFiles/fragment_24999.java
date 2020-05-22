public void remove(int index) {
  if (i == 0) {
      // TODO: do some checks (listPtr is set, has next...)
      listPtr = listPtr.next;
  }
  else {
      int currentIndex = 0;
      Customer currentElement = listPtr;
      while (currentIndex != size()) {
          if ((currentIndex + 1) == index) {
              currentElement.next = currentElement.next.next;
              break;
          }
          currentElement = currentElement.next;
          currentIndex++;
      }
  }
}