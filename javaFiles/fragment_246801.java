class SomeClass {
    static JLabel e = new JLabel("");
    public static void main(String[] args) {

        JButton b = new JButton("ok");
        b.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                String l = SomeClass.e.getText();

            }

        });

    }
}