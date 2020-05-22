public static <T extends Comparable<T>> void sort( int n, T[] array ) {
  T tempVar;
  for( int i = 0; i < n - 1; i++ ) {
    for( int j = 0; j < n - 1; j++ ) {
      if( array[i].compareTo( array[j + 1]) > 0 ) {
        tempVar = array[j + 1];
        array[j + 1] = array[i];
        array[i] = tempVar;
      }
    }
  }
}

class Student implements Comparable<Student> {
  public int compareTo( Student s ) {
    //compare gpa here
  }
}