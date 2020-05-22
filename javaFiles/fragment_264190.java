int myEmp = 0;
try {
  myEmp = fieldSet.readInt("EMPNO");
} catch (NumberFormatException nfe) {
  myEmp = 0;
}