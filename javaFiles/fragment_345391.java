@Command
public void doDeleteItems(@ContextParam(ContextType.VIEW) Component view) {
        logger.debug("Delete Icon selected");

if (myModel.getSelectedListItem() == null || myModel.getSelectedListItem().isEmpty()) {
            showError("No rows are selected");
        } else {

Messagebox.show("Are you sure you want to delete?", "Alert !!", Messagebox.YES | Messagebox.NO, Messagebox.QUESTION,new org.zkoss.zk.ui.event.EventListener() {

public void onEvent(Event evt) throws InterruptedException {
    if (evt.getName().equals("onYes")) {
//Add code for Deletion
  if (listModel.contains(deletedObj))
listModel.remove(deletedObj); 
}
else{
//Do somthing else
}
BindUtils.postNotifyChange(null, null, this, "*");//this means current viewmodel object and refresh the variables