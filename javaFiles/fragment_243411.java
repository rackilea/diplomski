List<Member> result = new ArrayList<>();
for(Member member : memberList)
    if ("male".equals(member.getGender()) 
                && member.getScore() > 50)
      result.add(member);

result.sort(Comparator.comparingInt(Member::getScore).reversed());
result.forEach(member -> {
     System.out.println("Name:  " +member.getName());
     System.out.println("Score: " +member.getScore()); 
     System.out.println();   
});