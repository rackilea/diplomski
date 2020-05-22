int lowest = Integer.MAX_VALUE;
int lowestIndex = 0;
for(int i=0;i<helTall.length;i++){
  System.out.println("Integers? ");
  input = tastatur.nextInt();  
  if (input < lowest){
    lowest = input;
    lowestIndex = i;
  }
  helTall[i]=input;
}
// swap the numbers
if (lowestIndex > 0) {
  int temp = lowest;
  helTall[lowestIndex] = helTall[0];
  helTall[0] = temp;
}
// display output
for (int i = 0; i < helTall.length; i ++) {
  System.out.println(helTall[i]);
}