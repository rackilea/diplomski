@Override
public boolean isRequired() {
    // The request parameter get lost on postbacks, however it's already present in the view scoped bean.
    // So we can safely skip the required validation on postbacks.
    return !FacesContext.getCurrentInstance().isPostback() && super.isRequired();
}