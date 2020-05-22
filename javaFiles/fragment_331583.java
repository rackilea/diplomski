//Action toolTipAction = component.getActionMap().get("postTip");
Action toolTipAction = component.getActionMap().get("hideTip");

if (toolTipAction != null)
{
    ActionEvent ae = new ActionEvent(component, ActionEvent.ACTION_PERFORMED, "");
    toolTipAction.actionPerformed( ae );
}