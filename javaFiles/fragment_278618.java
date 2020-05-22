if ("invalid".matches("(?=.*[?@$]).{2}b.{2}")) {
    System.out.println("invalid matches");
}
if ("12b?3".matches("(?=.*[?@$]).{2}b.{2}")) {
    System.out.println("12b?3 matches");
}