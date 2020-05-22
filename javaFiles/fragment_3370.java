public void actionPerformed(ActionEvent event) {
    // TODO Auto-generated method stub
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/people","root","desire");
        Statement stat = con.createStatement();
        stat.executeQuery("insert into name (first,last) values('"+s1+"','"+s2+"')");
        stat.close();
        con.close();
    }
    catch(Exception e){
        System.out.println("e.fillInStackTrace:" + e.fillInStackTrace());
        System.out.println("e.getCause:" + e.getCause());
        System.out.println("e.getLocalizedMessage:" + e.getLocalizedMessage());
        System.out.println("e.getMessage.:" + e.getMessage());
        System.out.println("e.getStackTrace:" + e.getStackTrace());
        System.out.println("e.initCause:" + e.initCause());
        System.out.println("e.printStackTrace:" + e.printStackTrace());
        System.out.println("e.toString:" + e.toString());       
    }
}