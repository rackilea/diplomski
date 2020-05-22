public StringProperty oldPremiumProperty() {
    return oldPremium ;
}

public final String getOldPremium() {
    return oldPremiumProperty().get();
}

public final void setOldPremium(String oldPremium) {
    oldPremiumProperty().set(oldPremium);
}