public Result(Org org, Candidate candidate) {
        super();
        this.orgId = org.getId();
        this.candidateId = org.getCandidateId();
        this.orgName = org.getName();
        this.candidateName = Optional.ofNullable(candidate).map(c -> c.getName()).orElse(null);
        this.candidateNum = Optional.ofNullable(candidate).map(c -> c.getNum()).orElse(null);
    }