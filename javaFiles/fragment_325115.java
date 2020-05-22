private void updateGames(
            int score, 
            int strikes, 
            int spares, 
            int splits, 
            int splitconversions, 
            int openframes, 
            int position, 
            String timestamp) {

        Games n = gamesList.get(position);
        n.setScore(score);
        n.setStrikes(strikes);
        n.setSpares(spares);
        n.setSplits(splits);
        n.setSplitConversions(splitconversions);
        n.setOpenFrames(openframes);
        n.setTimestamp(timestamp);
        db.updateGames(n);
        gamesList.set(position, n);
        mAdapter.notifyItemChanged(position);
        toggleEmptyGames();
    }