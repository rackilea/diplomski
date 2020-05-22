OnFacebookListener facebookListener;
public interface OnFacebookListener{
    void onFacebookLoggedIn(Profile profile);
}
public void setFacebookListener(OnFacebookListener onfacebooklistener){
    this.facebookListener=onfacebooklistener;
}