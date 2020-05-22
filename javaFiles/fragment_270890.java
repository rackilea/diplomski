private OnActionListener listener;
private JButton action;

public GUIForm(OnActionListener listener) {
    this.listener = listener;
    action = new JButton("Action");
    action.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            GUIForm.this.listener.onAction();
        }
    });
}