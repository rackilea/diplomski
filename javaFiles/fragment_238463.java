class MyFrame extends JFrame {
    public void someMethod () {
        someButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                ActionListener thisListener = this; // obviously
                MyFrame outerThis = MyFrame.this; // here's the trick
            }
        });
    }
}