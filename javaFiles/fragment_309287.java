public class LoginViewModel extends ViewModel implements Observable {
    private User user;
    private PropertyChangeRegistry callbacks;


    public LoginViewModel() {
        user = new User("Karlo","maricevic");
        callbacks = new PropertyChangeRegistry();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Bindable
    public String getUserName()
    {
        return user.getUserName();
    }

    public void setUserName(String userName)
    {
        user.setUserName(userName);
        notifyPropertyChanged(BR.userName);
    }

    @Bindable
    public String getLastName()
    {
        return user.getLastName();
    }


    public void setLastName(String lastName)
    {
        user.setUserName(lastName);
    }

    @Override
    public void addOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        callbacks.add(callback);
    }

    @Override
    public void removeOnPropertyChangedCallback(OnPropertyChangedCallback callback) {
        //callbacks.remove(callback);
    }

    void notifyPropertyChanged(int fieldId)
    {
        callbacks.notifyCallbacks(this,fieldId,null);
    }
}