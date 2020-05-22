try (ObjectInputStream contacts = new ObjectInputStream(new FileInputStream(CONTACTSSAVE))) {
   addAllContacts((HashSet<String>) contacts.readObject());
}

try (ObjectInputStream apikey = new ObjectInputStream(new FileInputStream(APIKEYSAVE))) {
    // load things from apikey
}