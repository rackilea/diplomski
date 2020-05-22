if (number < 0) {
  System.out.print("-");
  if (number == Integer.MIN_VALUE) {
    System.out.print(-(number % 10));
    number /= 10;
  }
  reverse(-number);
} else if ...