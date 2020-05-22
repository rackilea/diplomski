List<PersonDetails> personDetails = new ArrayList<>();
personDetails.add(new PersonDetails(1, "a"));
personDetails.add(new PersonDetails(2, "b"));
personDetails.add(new PersonDetails(3, "a"));
personDetails.add(new PersonDetails(4, "a"));

Map<String, PersonDetails> encountered = new HashMap<>();
for (PersonDetails pd : personDetails) {
  PersonDetails first = encountered.putIfAbsent(pd.residence, pd);
  if (first != null) {
    pd.isDuplicate = first.id;
    first.isDuplicate = first.id; // mark the first encountered as duplicate
  }
}