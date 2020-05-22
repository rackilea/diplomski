public class MyLabel extends JLabel {

    private static final long serialVersionUID = 1L;

    public MyLabel (String key) {
        super(key);
        // register this in event bus
        EventBusHolder.get().register(this);
    }

    @Override
    public String getText() {
        return Messages.getString(super.getText());
    }

    @Subscribe 
    public void recordCustomerChange(ChangeEvent e) {
        revalidate();
    }

}