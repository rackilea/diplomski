public class SomeCustomComponent extends JComponent {
    private SomeUpdateListener listener;
    public SomeCustomComponent(SomeUpdateListener someListener) {
         this.listener = someListener;
    }
    ...
    private void timeToMakeThatPanelContentUpdate() {
         PanelContent newContent = createNewPanelContents();
         listener.onUpdate(newContent);
    }
    ...