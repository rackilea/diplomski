Set<PhoneNumber> set = new HashSet();
set.add(obj);

// Modify object after it has been inserted
set.remove(obj);
obj.setNumber("089/358680-0");
set.add(obj);