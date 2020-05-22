int secondLargest = (int) list.get(0);
int largest = list.get(0);
for (int i = 1; i < list.size(); i++) {
  if(list.get(i) > largest) {
    secondLargest = largest;
    largest = list.get(i);
  }
  if(list.get(i) > secondLargest && list.get(i) != largest) {
    secondLargest = list.get(i);
  }
}
System.out.print("Second biggest number ");
return secondLargest;