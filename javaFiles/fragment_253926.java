int counter = 0;
while (counter < numbers.length) {
  if (sc.hasNextInt()) {
    numbers[counter++] = sc.nextInt();
  } else {
    if (sc.hasNext("finish")) {
      sc.close();
      break;
    } else {
      System.out.println("It's neither number nor 'finish'.");
      sc.next();
    }
  }
}

for (int x : numbers) {
  if (x > largestNumber) {
largestNumber = x;
  }
}

System.out.println("The largest number is: " + largestNumber);