List<Contact> contacts = new ArrayList<Contact>();
// Fill it.

// Sort by address.
Collections.sort(contacts, Contact.COMPARE_BY_ADDRESS);

// Sort later by phone.
Collections.sort(contacts, Contact.COMPARE_BY_PHONE);