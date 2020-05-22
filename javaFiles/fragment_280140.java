public class Configuration<T extends Action> {
    private Class<T> actionClass;

    public void setActionClass(Class<T> cls){
        this.actionClass = cls;
    }

    public Class<T> getActionClass(){
        return this.actionClass;
    }
}