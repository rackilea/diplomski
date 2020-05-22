try {
  foo = Long.parseLong(args[0]);
  bar = Long.parseLong(args[0]);
} catch (NumberFormatException e) {
  System.out.println(USAGE);
  System.exit(1);
  throw new RuntimeError("Make sure the end of the catch block is unreachable");
}