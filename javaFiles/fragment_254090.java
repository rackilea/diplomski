List<Contact> contacts = new ArrayList<Contact>();
// Fill it.

// Now sort by address instead of name (default).
Collections.sort(contacts, new Comparator<Contact>() {
    public int compare(Contact one, Contact other) {
        return one.getAddress().compareTo(other.getAddress());
    }
});