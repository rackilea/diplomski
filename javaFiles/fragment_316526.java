try {
                Connection conn = DriverManager.getConnection( Host, Name, Pass );      
                PreparedStatement pst = conn.prepareStatement("SELECT `user_name`, `user_email` FROM `table_1` WHERE `user_name` = ? AND `user_email` = ?");
                pst.setString(1, Username);
                pst.setString(2, Password);
                ResultSet Result = pst.executeQuery();
                if (Result.next()) {
                    JOptionPane.showMessageDialog(null, "Error Account with Infomation already exists.");
                } // if
                else {
                        PreparedStatement pst2 = conn.prepareStatement("INSERT INTO table_1 (user_name, user_pass, user_email, cid)"
                        + " VALUES (?, ?, ?, ?)");

                        pst2.setString(1, Username); //Check Username does not exist!
                        pst2.setString(2, Password);
                        pst2.setString(3, Email); //Check Email is not already used!
                        pst2.setString(4, cid); //Need to add verification that CID is not in use!

                        pst2.execute();
                    } // else
                   } // try
                    catch (Exception e3) {
                    e3.printStackTrace();
                   } // catch