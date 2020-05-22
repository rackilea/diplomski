@ViewDocking(...)
public class ListView extends SomeNode implements LocalContextProvider {

    private final SimpleContextContent contextContent = new SimpleContextContent();
    private final SimpleContext context = new SimpleContext(contextContent);
    private MyPojo currentSelection;

    ...

    @Override
    public Context getLocalContext() {
        return context;
    }

    ...

    if (currentSelection != null){
        contextContent.remove(currentSelection);
    }
    currentSelection = <current selection>
    if (currentSelection != null){
        contextContent.add(currentSelection);
    }
    ...
}