class DaoUser extends Observable {
  //other methods
  public User findUsers (int id_user) {
    //find your user. Once you find it
    setChanged();
    notifyObservers(user_found);
  }
}