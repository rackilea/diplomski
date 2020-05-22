private boolean rendered = true;

protected void onPagePreRender(PagePhaseEvent event) {
    rendered = false;
    AdfFacesContext.getCurrentInstance().addPartialTarget(getTable1());
}

public boolean isRendered() {
    return rendered;
}