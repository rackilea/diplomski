public void actionPerformed(ActionEvent arg0) { 
            Connection conn= c.getConnect();  
            if (conn!=null) {
                new Gui2(conn);//pass connection object here
                dispose();
            }

        }