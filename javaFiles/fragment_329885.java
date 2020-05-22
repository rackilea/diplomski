smallest = recB.get(0).getWidth() * recB.get(0).getHeight();
for (Rectangle rr : recB) {
  if (rr.getWidth() * rr.getHeight() < smallest) {
    smallestIndex = rr.getIndex();
  }
}

//Largest rectangle
largest = recB.get(0).getWidth() * recB.get(0).getHeight();
for (int i = 0; i < recB.size(); i++) {
  if (largest < recB.get(i).getWidth() * recB.get(i).getHeight()) {
    largestIndex = recB.get(i).getIndex();
   }
}

//Output smallest and largest rectangle
System.out.printf("The Smallest: Rectangle %d\n", smallestIndex);
System.out.printf("The Largest: Rectangle %d\n", largestIndex);