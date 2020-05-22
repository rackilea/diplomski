public static boolean add(Contact c) {
    contacts = new Contact[CAPACITY]; // remove this line
    if (count < CAPACITY) {
        contacts[count++] = c;
    }
    return false;
}