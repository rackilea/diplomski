FindReplaceAction findReplaceAction = new FindReplaceAction(bundle, "find_replace_action_", this); 
findReplaceAction.setActionDefinitionId(IWorkbenchCommandConstants.EDIT_FIND_AND_REPLACE);
setGlobalAction(ActionFactory.FIND.getId(), findReplaceAction);

protected void setGlobalAction(String actionID, IAction action) {
    IActionBars actionBars = getViewSite().getActionBars();
    actionBars.setGlobalActionHandler(actionID, action);
}