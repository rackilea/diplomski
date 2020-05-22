class CustomAdapter{
    List<member> mTempMembers;
    List<member> mMembers;

    ...

    showFavorite(boolean isShowFavoriteOnly){

        if(isShowFavoriteOnly){
            mMembers.removeAllExceptFavorite();
        }else{
            mMembers.removeAll(); 
            mMembers.addAll(mTempMembers);
            //mMembers = mTempMembers;
        }
        this.notifyDataSetChanged();

    }

}