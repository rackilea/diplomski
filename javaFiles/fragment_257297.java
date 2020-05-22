/* Adding a new model involves adding a new method to this base class. Not very 
 * elegant but that's the way the pattern works...  */
public class View {
    public void render(AModel model) { /* implement in subclass */ }    
    public void render(BModel model) { /* implement in subclass */ }
}

/* Providers provides the views with models, and serves to decouple
 * models from views */
public interface ModelProvider { 
    public void renderWith(View view); 
}

public class AModelProvider implements ModelProvider {
    private final AModel _model;
    public void renderWith(View  view) { view.render(_model); }
}

public class BModelProvider implements ModelProvider { 
    private final BModel _model;
    public void renderWith(View  view) { view.render(_model); }
}

public class AView extends View { 
    public void render(AModel model) { 
        model.doA(); 
    } 
}

public class BView extends View { 
    public void render(BModel model) { 
        model.doB(); 
    } 
}

public class Controller {
    public void renderModels(List<ModelProvider> providers, View view) {
        for (ModelProvider provider : providers) {
            // if provider is an AModelProvider and view is an AView,
            // render(AModel) will be called. If provider is a BModelProvider
            // or if view is BView, nothing will happen since the empty
            // View base class methods will be called...
            provider.renderWith(view);
        }
    }
}