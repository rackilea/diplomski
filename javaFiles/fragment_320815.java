Map<Integer,List<Person>> map = new HashHap<Integer,List<Person>>();

for (Person person : collectionOfPeople) {
    int cid = person.getCountryId();

    List<People> list = map.get(cid);

    if (list == null) {
        list = new ArrayList<People>();
        map.put(cid,list);
    }

    list.add(person);
}