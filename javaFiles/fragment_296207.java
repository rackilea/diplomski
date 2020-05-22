List<Person> people = dao.getListOfPeopleAttendingParty();

// assume that the number of people attending the party is 4
assert people.size() == 4;

Person guest = people.get(0);
dao.delete(guest);

// what is the number of people attending the party now?
assert people.size() == ?;