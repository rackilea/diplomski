if (mAllScore != null && mAllScore.size() > 0) {
      for(int i = 0,N=mAllScore.size();i<N;i++) {
          mScoreListAdapter.add(mAllScore.get(i));
      }
      mScoreListAdapter.notifyDataSetChanged();
  }