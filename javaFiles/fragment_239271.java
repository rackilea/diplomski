short[] Years = { 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,
        2009, 2010, 2011, 2012 };
String[] Months = { "January", "February", "June", "January", "March",
        "June", "July", "August", "September", "March", "November",
        "March", "June" };

String term = "March";
List<Short> indexes = new ArrayList<Short>();
for (int i = 0; i < Months.length; i++) {
    String string = Months[i];
    if (term.equals(string)) {
        indexes.add(Years[i]);
    }

}

for (Short short1 : indexes) {
    System.out.print(short1);
}