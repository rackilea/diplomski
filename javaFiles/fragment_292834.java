@ProcessAdditions
public void processAdditions(MApplication app, EModelService modelService)
{
  MUIElement el = modelService.find("part.id.activity", app);
  if (el != null) {
    el.setToBeRendered(false);
  }
}