List<Match> matchesToday = matchInvService.fetchMatchByDate(today);
List<MatchDTO> responseList = new ArrayList<Match>();  

for (Match stats : matchesToday) {
 if (stats != null) {
    MatchDTO match = new MatchDTO(stats);
    responseList.add(match); 
  } 
}

return responseList;