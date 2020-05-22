List<Candidate> rank = new ArrayList<Candidate>(ballot.values());
    Collections.sort(rank, new Comparator<Candidate>() {
        @Override
        public int compare(Candidate o1, Candidate o2) {
            return o2.getVotes() - o1.getVotes();
        }
    });