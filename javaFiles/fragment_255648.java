ArrayList<Entry> entries = new ArrayList<>();
String[] info = new String[3];
String name;
String phone;
String email;

while (sc.hasNextLine()) {

    do {
        info[0] = sc.nextLine();
    } while (!sc.nextLine().isEmpty());
    // this ensures that empty lines will not be treated as if they contained information

    info[1] = sc.nextLine();
    info[2] = sc.nextLine();
    // all three lines in the entry have now been assigned to Strings

    for (int i=0; i<3; i++) {
        if (info[i].startsWith("Name") {
            name = info[i];
        } else if (info[i].startsWith("Phone") {
            phone = info[i];
        } else if (info[i].startsWith("Email") {
            email = info[i];
        }
    }

    entries.add(new Entry(name, phone, email));
}