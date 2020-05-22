public void deleteEntry(String number) {
    int size = phoneBook.size();
    for (ListIterator<Entry> i = phoneBook.listIterator(); i.hasNext(); ) {
        Entry e = i.next();
        if (e.getNumber().equals(number)) {
            i.remove();
            break;
        }
    }
    if (phoneBook.size() == size) {
        System.out.println("Entry not found");
    }
}