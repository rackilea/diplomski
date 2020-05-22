ArrayList<Integer> phones = new ArrayList<>();
 ArrayList<Name> names = new ArrayList<>();
 phones.add(8888);
 phones.add(9999);
 names.add(new Name("Shaun-Williams", "Joe"));
 names.add(new Name("Baltimore", "Paul"));
 //pass the object after you've done your initializations
 PhoneBook pb = new PhoneBook(names, phones);
 pb.print();