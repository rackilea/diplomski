Comparator<Friend> favoriteComparator = new Comparator<FriendListResponse.Friend>() {
    @Override
    public int compare(Friend lhs, Friend rhs) {
        int i=0,j=0;
        if(lhs.isFavorite()&&lhs.isFriend())
           i++;
        if(lhs.isFriend())
           i++;
        if(rhs.isFavorite()&&rhs.isFriend())
           j++;
        if(rhs.isFriend())
           j++; 
        return i-j;
    };
};