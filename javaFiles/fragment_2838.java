@Override
public void onLeaderboardScoresLoaded(int arg0, LeaderboardBuffer arg1, LeaderboardScoreBuffer arg2) {
    Iterator<LeaderboardScore> it = arg2.iterator();
    while(it.hasNext()) {
         LeaderboardScore temp = it.next();
         Log.d("debug", "player:" + temp.getScoreHolderDisplayName() + " id:" + temp.getScoreHolder().getPlayerId());
    }
}