public static double findUnique(double array[]) {
    if(array.length < 3) { 
       throw new IllegalArgumentException("wrong array");
    }

    double common;
    if(array[0] == array[1]) {
       common = array[0];
    } else {
       return array[0] != array[2]? array[0]: array[1];
    }

    for(int i=2; i<array.length; i++) {
       if(common != array[i]) {
          return array[i];
       }
    }
    throw new IllegalArgumentException("wrong array"); 
}