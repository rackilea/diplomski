while (!in.hasNextInt()) {
  in.next();
  System.out.println("Input must be a number.");
}

int numA = in.nextInt();

while (numA < 0 || numA > 10) {
  System.out.print("Enter a number 1-10: "); 
  numA = in.nextInt(); 
}

A.add(numA);