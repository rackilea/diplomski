public static void main(String[] args) 
    String [] s = {"1", "2"};
    DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>(s);
    JComboBox<String> j = new JComboBox<String>(s);
    j.setModel(model);

    j.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent arg0) {
            System.out.println(((JComboBox) arg0.getSource()).getSelectedItem());               
        }
    });

    JFrame jf = new JFrame();
    jf.add(j);
    jf.setVisible(true);
    jf.setSize(100, 100);

    model.removeAllElements();
}