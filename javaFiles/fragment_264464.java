public void changeOwner(AjaxBehaviorEvent event) {
    try {
        update.updateOwner(...params...);
        JSF.setMessage(Messages.UPDATE_OK);
    } catch (UpdateDBException ex) {
        JSF.setMessage(ex.getMessage());
    }
}