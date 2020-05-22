btnNewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChildWindow prompt = new ChildWindow(frame); // or use null for no parent

        prompt.getDialog().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                e.getWindow().removeWindowListener(this);
                frame.dispose();
            }
        });
    }
});