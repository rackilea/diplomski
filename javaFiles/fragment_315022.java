public class XXX {
   @Inject private EModelService modelService;
   @AboutToShow 
   public void aboutToShow(List<MMenuElement> items, ...) {

      // insert your logic here to add an entry or not...
      // maybe with a loop of some sort...
      MDirectMenuItem dynamicItem = modelService.createModelElement(MDirectMenuItem.class);
      dynamicItem.setLabel(<;abel>);
      dynamicItem.setIconURI(<icon>);
      dynamicItem.setContributorURI("platform:/plugin/<your plugin name>");
      dynamicItem.setContributionURI("bundleclass://<your plugin name>/<class handler>");
      dynamicItem.getTransientData().put(<name>, <value>); // To pass parameters to the handler

      items.add(dynamicItem);
  }