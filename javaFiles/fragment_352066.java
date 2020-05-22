List<String> organizations = Arrays.asList(
    "Service Provider organisation 3 01254 25742", // count=3
    "Service Provider test 2 132455 132455",       // count=1
    "Service Provider organisation 2 78900 6521",  // count=3
    "VOYAGES ANSELMINO 30876168300025 382510022",  // count=1
    "Service Provider test 1 32722 21211",         // count=2
    "SP recherche autocomplete 7897788 7897788")   // count=1
    .stream().map(String::toLowerCase).sorted(new Comparator<String>() {
        @Override
        public int compare(String o1, String o2) {
            return getCountMeetCondition(o2) - getCountMeetCondition(o1);
        }
}).collect(Collectors.toList());

private static int getCountMeetCondition(String s) {
    int count = 0;
    for (int i = 0; i < arrayOfString.size(); i++) {
        if (s.contains(arrayOfString.get(i))) {
            count++;
        }
   }
   return count;
}