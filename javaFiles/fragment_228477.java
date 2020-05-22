boolean more;
do {
  insertOneUser();
  System.out.println("Add another?");
  more = "y".equals(input.next().toLowerCase());
} while (more);