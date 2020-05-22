String[] arr = { "A", "B", "C", "D", "E" };
String[] reversed = new String[arr.length];

for(int i = 0, j = arr.length-1 ; i < arr.length; i++, j--) {
  reversed[j] = arr[i];
}