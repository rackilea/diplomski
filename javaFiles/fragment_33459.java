@Override
public String toString() {
  StringBuilder stringBuilder = new StringBuilder();
  Formatter formatter = new Formatter(stringBuilder);

  String template = "%-7s %-15s %-15s %-35.2f %-5.2f $ %-8.2f"; // a rough guess!
  formatter.format(template, getEmpID(), getLastName(), getFirstName(), 
            getHours(), getRate(), getGross());
  return stringBuilder.toString();
}