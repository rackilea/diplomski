int[] one = new int[3];
int[] two = new int[3];

void setup(){
  one[0] = 0;
  one[1] = 1;
  one[2] = 2;

  print("one firstPrint -> \n");
  println(one);

  two = one;

  print("two firstPrint -> \n");
  println(two);

  two[2] = 4;

  // we didn't mean to change one, but...
  print("one secondPrint -> \n");
  println(one); 
}