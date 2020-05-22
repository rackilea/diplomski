int half = Math.floor(array/2);
int numberOfElementsInArray = array[0].length;
String [][] A = new String[half][numberOfElementsInArray];
String [][] B = new String[array.length - half][numberOfElementsInArray];
System.arraycopy(array,0,A,0,half);
System.arraycopy(array,half,B,0,array.length - half);