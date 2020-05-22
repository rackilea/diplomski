class thehandler implements ActionListener {
     public void actionPerformed(ActionEvent event){
         String password = new String(field.getPassword());
         if (password.equals("admin")){
             JOptionPane.showMessageDialog(null, password);
         }
     }
}