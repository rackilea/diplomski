JFrame frame = new JFrame();
        JTextField text = new JTextField();
        frame.add(text);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                text.requestDefaultFocus();
            }
        });