Contact c1 = new Contact("Name1");
Contact c2 = new Contact("Name2");
Contact c3 = new Contact("Name3");

ArrayList<Contact> contactList = new ArrayList<Contact>();
contactList.add(c1);
contactList.add(c2);
contactList.add(c3);

for (int i = 0; i < contactList.size(); i++) {
     System.out.println(contactList.get(i).name1);
     // your code...
}