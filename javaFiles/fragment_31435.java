public abstract class AbstractController {

private List<AbstractViewPanel> registeredViews;
private List<AbstractModel> registeredModels;

public AbstractController(List<AbstractViewPanel> registeredViews, List<AbstractModel> registeredModels) {
    this.registeredViews = registeredViews;
    this.registeredModels = registeredModels;
}