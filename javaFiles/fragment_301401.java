public class BusinessLogic extends BaseObservable {

private boolean isToggleOn;

public BusinessLogic() {
    isToggleOn = false;
}

public void toggleVisibility(boolean toggleOn) {
    isToggleOn = toggleOn;
    notifyPropertyChanged(BR.toggleOn);
}

@Bindable
public boolean getToggleOn() {
    return isToggleOn;
}