@Override
 public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (isVisibleToUser) {
        // Refresh your fragment here
        cellPhoneList = dao.getAllFavoriteCellphone();
        mAdapter.setData(cellPhoneList);
    }
 }