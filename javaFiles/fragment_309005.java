List<Integer> votes= new ArrayList<Integer>() ;
    for(Candidate c:candidates)
    {
       votes.add(c.GetVote()) ;
    } 
    for(Integer v:votes)
    {
      System.out.println(v);
    }