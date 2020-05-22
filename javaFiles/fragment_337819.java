public String getWinner()
{
    final Map<String, Integer> votesCount = new HashMap<String, Integer>();

    String winner = ballots.get(0);
    int winnerVotes = 1;

    for(final String ballot : ballots)
    {
        if (!votesCount.containsKey(ballot))
            votesCount.put(ballot, 0);
        votesCount.put(ballot, votesCount.get(ballot)+1);
        if (votesCount.get(ballot)>winnerVotes)
        {
            winner = ballot;
            winnerVotes = votesCount.get(ballot);
        }
    }
    return winner;
}