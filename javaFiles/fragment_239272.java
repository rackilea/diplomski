Scanner keyboard = new Scanner(System.in);

    short[] Years = { 2000, 2001, 2002, 2003, 2004, 2005, 2006, 2007, 2008,
            2009, 2010, 2011, 2012 };
    String[] Months = { "January", "February", "June", "January", "March",
            "June", "July", "August", "September", "March", "November",
            "March", "June" };

    String term = keyboard.next();

    List<String> results = new ArrayList<String>();
    for (String s : Months) {
        if (s.equals(term)) {
            results.add(s);
        }
    }
    if (results.size() > 0) {
        System.out.println("The month " + term + "appears "
                + results.size() + " times");
    } else {
        System.out.println("Your search for " + term
                + " did not return any results");
    }

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
}