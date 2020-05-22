String descr = jt.getValueAt(0, 1).toString();
int storedValue = 0;

//check if your value is a correct integer or not
if (descr.matches("\\d+")) {
    storedValue = Integer.parseInt(descr);

} else {
    System.out.println("Exception");
}
System.out.println(storedValue);