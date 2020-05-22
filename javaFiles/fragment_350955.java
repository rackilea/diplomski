final class FooButton extends JButton {
    Foo() {
        super("Foo");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FooButton button = FooButton.this;
                // ... do something with the button
            }
        });
    }
}