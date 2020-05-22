private void buttonConnectActionPerformed(java.awt.event.ActionEvent evt) {
        jLabel.setText("Connecting ...");

        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                         String url = "jdbc:mysql://domain.com:3306/tablename";
                         String user = "username";
                         String password = "userpassword";



                         con = DriverManager.getConnection(url, user, password);        

                     } catch (SQLException ex) {
                         Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
}
            }
        }
        )).start()        
}