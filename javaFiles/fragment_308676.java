for (int i = 0; i < mArchive.mArchive.size(); ++i) {
    Bitmap im = getFacebookPhoto(mArchive.mArchive.elementAt(i).mTo);   
    mArchive.mArchive.elementAt(i).mImage.setImageBitmap(im);
}
if(mArchiveListAdapter!=null){
    mArchiveListAdapter.notifyDataSetChanged();
} else {
    //fallback
     mArchiveListAdapter = new ArchiveListAdapter(getActivity(),mArchive.mArchive);
     mScrollView.setAdapter(mArchiveListAdapter);
}