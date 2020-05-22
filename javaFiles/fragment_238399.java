public void onResponse(TopScoreObject[] response) {
        try {
            if(response != null){
                ArrayList<TopScoreObject> mList = arrayToListObject(response);
                if(mList.size() > 10)
                    mList.subList(10, mList.size()).clear();

                Collections.sort(mList, new Comparator<TopScoreObject>() {
                    @Override
                    public int compare(TopScoreObject topScoreObject, TopScoreObject t1) {
                        return Integer.parseInt(topScoreObject.getScores()) - Integer.parseInt(t1.getScores());
                    }
                });
                Collections.reverse(mList);
                mAdapter = new LadderBoardAdapter(mList);
                mRecyclerView.setAdapter(mAdapter);