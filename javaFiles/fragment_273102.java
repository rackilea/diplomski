static void sortAlphabetical() {
    String nameSwap;
    int [] markSwap;
    boolean flag = false;
    while (!flag) {
      flag = true;
      for (int i = 0;i < nameArrayCount-1;i++) {
        if (studentNamesArray[i].compareTo(studentNamesArray[i + 1]) > 0) {
          nameSwap = studentNamesArray[i];
          studentNamesArray[i] = studentNamesArray[i + 1];
          studentNamesArray[i + 1] = nameSwap;
          markSwap = studentMarksArray[i];
          studentMarksArray[i] = studentMarksArray[i + 1];
          studentMarksArray[i + 1]= markSwap;
          flag = false;
        }
      }
    }
  }