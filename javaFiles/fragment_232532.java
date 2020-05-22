public class AddViewPane extends JPanel implements AddView {

    private JButton btn;
    private JLabel label;

    public AddViewPane() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;

        btn = new JButton("Add");
        label = new JLabel("...");

        add(btn, gbc);
        add(label, gbc);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fireAddAction();
            }
        });
    }

    @Override
    public void setData(int data) {
        label.setText(NumberFormat.getNumberInstance().format(data));
    }

    @Override
    public void addActionListener(ActionListener listener) {
        listenerList.add(ActionListener.class, listener);
    }

    @Override
    public void removeActionListener(ActionListener listener) {
        listenerList.remove(ActionListener.class, listener);
    }

    protected void fireAddAction() {
        ActionListener[] listeners = listenerList.getListeners(ActionListener.class);
        if (listeners.length > 0) {
            ActionEvent evt = new ActionEvent(this, ActionEvent.ACTION_PERFORMED, ADD_ACTION_COMMAND);
            for (ActionListener listener : listeners) {
                listener.actionPerformed(evt);
            }
        }
    }

}