public class LoginUI {

      ...
       ResultSet rs;

       public ResultSet getRs() {
          return rs;
       }
       ...
      btnLogin.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String uname = tfUname.getText().trim();
                String pwd = tfPwd.getText().trim();

                LoginDbConn loginDbConn = new LoginDbConn(uname, pwd);// startDB after user presses     
                rs = loginDbConn.getConn();

            } catch (Exception ex) {
                // TODO: handle exception
            }

        }
    });

    ....
 }