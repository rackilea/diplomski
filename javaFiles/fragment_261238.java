private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {

        try{
            readFile();
            if (login==true) {
                JOptionPane.showMessageDialog(null, "login Success");
                Laptop LAP = new Laptop();

                JFrame frame = new JFrame();
                JPanel panel = new JPanel();

                panel.setSize(900, 600);
                panel.setBackground(Color.decode("#a020f0"));

                LAP.btnLaptop.setBounds(20, 20, 120, 30); 
                LAP.btnLaptop.setFont(new Font("Arial",(Font.BOLD),15));
                LAP.btnLaptop.setBackground(Color.decode("#7d26cd"));

                LAP.btnTrans.setBounds(160, 20, 120, 30); 
                LAP.btnTrans.setFont(new Font("Arial",(Font.BOLD),15));
                LAP.btnTrans.setBackground(Color.decode("#7d26cd"));

                LAP.btnHist.setBounds(300, 20, 120, 30); 
                LAP.btnHist.setFont(new Font("Arial",(Font.BOLD),15));
                LAP.btnHist.setBackground(Color.decode("#7d26cd"));

                frame.setVisible(true);
                frame.setSize(900, 600);
                frame.add(LAP.btnLaptop);
                frame.add(LAP.btnTrans);
                frame.add(LAP.btnHist);
                frame.add(panel);

            }
            else{
                JOptionPane.showMessageDialog(null, "Login Failed");

            }
        }
        catch(IOException ioe){

        }

    }