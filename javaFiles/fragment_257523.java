String line = inPut.nextLine();
String[] Company = new String[3];
int[] Price = new int[3];
int[] Quality = new int[3];
int count = 0;
while(inPut.hasNext()){
  Company[count] = inPut.next();
  Price[count] = inPut.nextInt();
  Quality[count] = inPut.nextInt();
  count++;
}