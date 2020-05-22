Double[] doubleArr = null;
Integer[] intArr = null;

doubleArr = intArr ;      // Compile error, Double,Integer are sibling classes
doubleArr = (Double[]) intArr;  // Compile error, same reason
intArr = doubleArr;             // Compile error, same reason
intArr = (Integer[]) doubleArr; // Compile error, same reason