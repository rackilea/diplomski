String firstname = JOptionPane.showInputDialog("First Name");
String secondname = JOptionPane.showInputDialog("Second Name");
String password = JOptionPane.showInputDialog("Your Password");

if(null == firstname || null == secondname || null == password)
{
    throw new IllegalArgumentException("Missing Parameters!");
}
else
{
    try
    {
        String query="insert into student (firstname,secondname,password) values (?,?,?)";
        PreparedStatement pst=connection.prepareStatement(query);
        pst.setString(1, firstname);
        pst.setString(2, secondname);
        pst.setString(3, password);

        pst.execute();

        pst.close();

    }
    catch (Exception ex)
    {
        JOptionPane.showMessageDialog(null,"Something Went Wrong!");
    }

}