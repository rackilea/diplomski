@Override
public void onAttach(Activity activity) {
    super.onAttach(activity);
    if (getTextCallback == null) {
        getTextCallback = (GetTextCallback) activity;
    }
}

public void whenYouWantToGetText() {
    if (getTextCallback != null) {
        getTextCallback.getTextYouWant();
    } 
}