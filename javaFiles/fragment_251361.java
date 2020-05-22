Map<Integer, Candidate> candidateById = listCandidate.stream()
        .collect(Collectors.toMap(Candidate::getId, Function.identity()));
List<Result> resultList = listOrg.stream()
        .map(o -> {
          Candidate candidate = candidateById.getOrDefault(o.getCandidateId(), new Candidate(-1, null, null));
          return new Result(o.getId(), o.getCandidateId(), o.getName(), candidate.getName(), candidate.getNum());
    })
    .collect(Collectors.toList());