private static final String[] contactsFirstNameData;

static {
    LinkedList<String> l = new LinkedList<>();
    l.add("Emerson");
    l.add("Lake");
    l.add("Palmer");
    contactsFirstNameData = l.toArray(String[]::new);
}