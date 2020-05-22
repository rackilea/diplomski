@Listen("onClick = #Car")
public void carClicked(Event ev){
   // clear old content
   currentSite.getChildren().clear();
   // add the new
   Executions.createComponent("/zul/car.zul", currentSite, null);
}