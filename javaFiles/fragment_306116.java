if (left > right) {
     return false;
 }
 middle = (left + right)/2;
 int compare = V.compareTo(A[middle]);
 System.out.println("Middle value: "+middle);
 if (compare == 0) {
     binaryOutput.setText("The book is: "+bookList[middle]);
     return true; // Missing!
 }
 if (compare < 0) {
     return binarySearch(A, left, (middle-1), V);
 } else {
     return binarySearch(A, middle + 1, right, V);
 }