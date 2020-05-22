public Vote createVote() {
    Vote vote = new Vote();
    vote.setEvent(this);
    votes.add(vote);
    return vote;
}