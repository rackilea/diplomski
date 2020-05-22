boolean add = true;
do {
  int lastDigit = num % 10;
  if (lastDigit != 3 && lastDigit != 4) {
    add = false;
  }
  num /= 10;
} while (add && num > 0);

if (add) {
  // Add to list.
}