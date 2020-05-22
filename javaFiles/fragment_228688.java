if (firstnameTf.getText().isEmpty() || lastnameTf.getText().isEmpty()){
        JOptionPane.showMessageDialog(null, "Please Insert");
    } 



else{
          myStatement =con.prepareStatement(query);

           myStatement.setString(1,firstnameTf.getText());
           myStatement.setString(2, lastnameTf.getText());
           myStatement.executeUpdate();}