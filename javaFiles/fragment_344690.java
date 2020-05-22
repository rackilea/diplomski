int start = 0;
while (start < items.size()) {
  // Move the end pointer until your total exceeds 800.
  int end = start + 1;
  int totalAmount = items.get(start).getAmount();
  while (end < items.size()) {
    int amount = items.get(end).getAmount();
    if (totalAmount + amount > 800) {
      break;
    }
    totalAmount += amount;
    end++;
  }

  // Now flush the sublist between start and end:
  createFile(items.subList(start, end));

  // Now move on to the next.
  start = end;
}