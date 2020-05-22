public class WorkingIndicator extends Composite {

    private static WorkingIndicator instance = null;

    private WorkingIndicator(){
       initWidget(new Label("Working"));
    }

    public static WorkingIndicator getInstance() {
       if (instance == null) {
          instance = new WorkingIndicator();
      }
      return instance;

    }

    public void show() {
        RootLayoutPanel.get().add(this);
    }

    public void hide() {
        RootLayoutPanel.get().remove(this);
    }

}