btnNewButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ChildWindow prompt = new ChildWindow(frame); // or use null for no parent

        prompt.getDialog().addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                // .. get some information from the child before disposing 
                System.out.println("Window closed."); // does not terminate when passing frame as parent
                if (frame.isVisible()) {
                    frame.dispose();
                }
            }
        });
    }
});