public void setFirstName(String firstName)
{

    try{
    // Here you create a READing statement.
        statement= con.prepareStatement("SELECT * FROM guest WHERE firstName = ?");
        statement.setString(1, firstName);
        ResultSet rs = statement.executeQuery();
        while(rs.next()){
    // Here you set the >>method param<< to a non-existing String
            firstName = rs.getString(1);
        }
    }catch(Exception e){
       System.out.print(e);
    }
}
// After the method is done you have done nothing because you didn't even set your class member variable "firstName", which you would have set using "this.firstName".