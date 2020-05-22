public Boolean getRenderUserId() {
    return (Boolean) getStateHelper().eval("renderUserId", Boolean.FALSE);
}

public void setRenderUserId(Boolean renderUserId) {
    getStateHelper().put("renderUserId", renderUserId);
}