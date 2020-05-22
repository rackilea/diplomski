int intNumber = in.nextInt();
array = new int[intNumber+1];
for (int a = 1; a <=intNumber; a++) {
  array[a] = in.nextInt();

} 
 x = array[array[array.length-1]];
 y = array[array[array.length-2]];
System.out.println(x * y);