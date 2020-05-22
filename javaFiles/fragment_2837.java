if (isSignedIn()) {
    getGamesClient().loadPlayerCenteredScores(
        this,
        getResources().getString(R.string.leaderboard_id),
        LeaderboardVariant.TIME_SPAN_ALL_TIME,
        LeaderboardVariant.COLLECTION_SOCIAL,
        25,
        true
    );
}