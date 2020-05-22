public class Two extends JFrame {

    public static void main(String[] args) throws Exception {
        new Two().a();
    }

    void a() throws Exception {
        this.setLayout(new GridLayout(2, 1));
        MaskFormatter formatter = new MaskFormatter("#");
        formatter.setValidCharacters("123456789");
        final JFormattedTextField field = new JFormattedTextField(formatter);
        JButton b = new JButton("null!");
        b.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                field.setValue(null);
            }
        });
        this.add(field);
        this.add(b);
        this.setSize(100, 100);
        this.setVisible(true);
    }
}