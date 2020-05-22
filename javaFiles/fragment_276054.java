try (PreparedStatement pst = conn.prepareStatement(sql))//use try with resources
            {
            pst.setString(1, loginField.getText());
            pst.setString(2, passwordField.getText());
            ResultSet rs = pst.executeQuery();
            int countUsr = 0;
            while(rs.next()){
                countUsr++;
            }
            if(countUsr == 1){
                loginFrame.dispose();
                AdminFrame adminFrame = new AdminFrame();
                adminFrame.setVisible(true);
            }else  if(countUsr > 1){
                JOptionPane.showMessageDialog(null, "ERR");
            }else{
                JOptionPane.showMessageDialog(null, "ERR");
                passwordField.setText("");
            }
        //removed rst closing, no need to close if your PreparedStatement is being closed.
        //No need to explicitly close our PreparedStatement since we are using try with resources
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "ERR: "+e.getMessage());
        }
    }