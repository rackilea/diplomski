public void actionPerformed(ActionEvent arg0) {
      conn = DriverManager.getConnection(server,user,pass);
      state = conn.createStatement();
      //do query here
      set.close();
      state.close()
      conn.close();
}