try {
  foo = Long.parseLong(args[0]);
  bar = Long.parseLong(args[0]);
} catch (NumberFormatException e) {
  throw new UserInputException("foo and bar must both be valid integers");
}