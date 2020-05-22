@Override
  public boolean equals(Object other) {
    if(other instanceof User){
        User user = (User) other;
        return userId.equals(user.userId);
    }

    return false;
}