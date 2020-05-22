public static <T> void sort( int n, T[] array, Comparator<T> comparator ) {
  T tempVar;
  for( int i = 0; i < n - 1; i++ ) {
    for( int j = 0; j < n - 1; j++ ) {
      if( comparator.compare( array[i], array[j + 1]) > 0 ) {
        tempVar = array[j + 1];
        array[j + 1] = array[i];
        array[i] = tempVar;
      }
    }
  }
}

BubbleSort.sort( students.length, students, new Comparator<Student>() {
  public int compare(Stundent lhs, Student rhs ) {
    //compare gpa
  }
});