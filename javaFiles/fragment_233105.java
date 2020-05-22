public static List<String> displayDuplicateNames(List<Member> members) {
      Map<String, Map<String, Set<Member>>> allMembers = new TreeMap<>();
      Map<String, Integer> dups = new HashMap<>();
      // For loop to initialize the Map
      for (Member member : members) {
         String club = member.getClub();
         String name = member.getName();
         Map<String, Set<Member>> clubList =
               allMembers.computeIfAbsent(club, k -> new TreeMap<>());
         Set<Member> nameList =
               clubList.computeIfAbsent(name, k -> new TreeSet<>());
         nameList.add(member);
      }
      allMembers.forEach((club, clubList) ->
      {
         System.out.printf("%n*** Club %s:%n", club);
         clubList.forEach((name, nameList) ->
         {
            System.out.printf("   ** Member's Name with Multiple Clubs:  
            %s%n",
                  name);
            if (dups.containsKey(name)) {
               dups.put(name, dups.get(name) + 1);
            }
            else {
               dups.put(name, 1);
            }
         });
      });

      return dups.entrySet().stream().filter(e -> e.getValue() > 1).map(
            Entry::getKey).collect(Collectors.toList());
   }
}