@Override
public void componentShown(ComponentEvent e) {
     try {
        Class.forName("com.mysql.jdbc.Driver");
con = DriverManager.getConnection("jdbc:mysql://localhost:3306/online", "root","");
        st = con.prepareStatement("select question,op1,op2,op3,op4 from java");
        rs = st.executeQuery();
    } catch (ClassNotFoundException | SQLException ex) {
  }
}