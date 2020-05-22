public abstract class AbstractController {

private List<AbstractViewPanel> registeredViews;
private List<AbstractModel> registeredModels;

public AbstractController() {
}

public void setRegisteredViews(List<AbstractViewPanel> views) {
   this.registeredViews = views;
}

public void setRegisteredModels(List<AbstractModel> models) {
   this.registeredModels = models;
}