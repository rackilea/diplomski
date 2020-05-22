Calendar cal = Calendar.getInstance();
try {
    cal.setTime(theConcernedDate);
}
catch (Exception e) {
  System.out.println("Invalid date");
}