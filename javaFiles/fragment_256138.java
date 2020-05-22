for(int i = 0; i<size-1; i++) {
     for (int j = i+1; j<myArray.length; j++) {
        if(myArray[i].compareTo(myArray[j])>0) {
           String temp = myArray[i];
           myArray[i] = myArray[j];
           myArray[j] = temp;
        }
     }
  }