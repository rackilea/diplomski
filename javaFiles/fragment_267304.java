List<MatchDTO> responseList =   
    matchInvService.fetchMatchByDate(today)
                   .stream()
                   .filter(Objects::nonNull)
                   .map(MatchDTO::new)
                   .collect(Collectors.toList);