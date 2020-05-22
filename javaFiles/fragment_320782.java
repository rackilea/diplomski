@Override
public boolean equals(Object otherUser) {
    if(otherUser instanceof User)
        return ((User) otherUser).getUserId() == getUserId();
    else
        return false;
};