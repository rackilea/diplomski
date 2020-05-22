public interface ConnectionPanelListener{
    void onOkButtonClicked(String... options);

    void onCancelButtonClicked();
}


public class AddConnectionPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private ConnectionPanelListener listener;


    public AddConnectionPanel(){
        final Map<ConnectionOptions, JTextField> components = new HashMap<>(ConnectionOptions.values().length);

        for(ConnectionOptions option:ConnectionOptions.values()){
            this.add(new JLabel(option.labelCaption));

            JTextField textField = new JTextField();
            //setup textField;
            this.add(textField);

            components.put(option, textField);
        }
        JButton button = new JButton("OK");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent pE) {
                super.mouseClicked(pE);
                //TODO validate TextFields

                Collection<String> inputs = new Stack<>();

                for(Entry<?,JTextField> e : components.entrySet()){
                    String text = e.getValue().getText();

                    if(text==null || text.trim().isEmpty()){
                        //TODO improve input validation
                        System.out.println("Input text is empty for: "+e.getKey());
                    } else {
                        inputs.add(e.getKey() + ": " + text);
                    }
                }
                listener.onOkButtonClicked(inputs.toArray(new String[inputs.size()]));
            }
        });
        this.add(button);
        button = new JButton("cancel");
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(final MouseEvent pE) {
                super.mouseClicked(pE);

                listener.onCancelButtonClicked();
            }
        });
        this.add(button);
    }

    public void setConnectionPanelListener(final ConnectionPanelListener l){
        listener = l;
    }

    private enum ConnectionOptions{
        IP_ADDRESS("IP-Address:"), PORT("Port:"), WHATEVER_ATTRIBUTE_YOU_NEED("Extras:"); 

        private String labelCaption;

        private ConnectionOptions(final String caption) {
            labelCaption = caption;
        }
    }
}