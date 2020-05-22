Gson gson = new Gson();

List<Contact> contacts = gson.fromJson("JSON STRING", new TypeToken<List<Contact>>() {}.getType());

Contact newContact = new Contact();
// set properties
contacts.add(newContact);

String json = gson.toJson(contacts);