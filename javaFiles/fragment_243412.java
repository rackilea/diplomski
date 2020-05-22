Arrays.stream(memberList) // create a Stream<Member>
      .filter(m -> "male".equals(m.getGender()) &&
            m.getScore() > 50) // retain only male members with score greater than 50
      .sorted(Comparator.comparingInt(Member::getScore).reversed()) // sort based on score descending i.e. highest to lowest
      .forEachOrdered(m -> {
             System.out.println("Name:     " +m.getName());
             System.out.println("Handicap: " +m.getScore());
             System.out.println();   
      }); // print the result