class Handler implements ActionListener{
        @Override
    public void actionPerformed(ActionEvent e){
        try {
            int a = Integer.parseInt(t1.getText());
            int b = Integer.parseInt(t2.getText());
            int r = a+b;
            l4.setText("Answer"+r);
        } catch (Exception e) {
           JOptionPane.showMessageDialog(MyOwn.this, "You've entered a wrong number", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}