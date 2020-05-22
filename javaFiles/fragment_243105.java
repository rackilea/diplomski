private Set<Entry> entries = new TreeSet<>();

public void addEntry(String surname, String initial, String number) {
        if (surname == null || initial == null || number == null)
            throw new IllegalArgumentException("Please fill all the required fields, [surname,initials,number]");
        else {
            Entry entry=new Entry(surname,initial,number);
            entries.add(entry);
        }
 }