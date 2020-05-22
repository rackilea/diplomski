...
  if (monthNumber == 12)
      return "December";

  // No case matched.
  throw new IllegalArgumentException("Bad month number: " + monthNumber);
}