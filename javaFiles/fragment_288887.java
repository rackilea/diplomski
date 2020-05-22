//FOR DUPLICATE INPUTS!!!!!!!!!!!!!!!!
   try 
    {
        Connection con = getConnection();
        String query = "SELECT studName, studNum, studYrLvl, studKors, studGender FROM studinfo WHERE studName=?, studNum=?, studYrLvl=?, studKors=?, studGender=?";
        PreparedStatement checkdup = con.prepareStatement(query);
        checkdup.setString(1, studName);
        checkdup.setString(2, studNum);
        checkdup.setString(3, studYrLvl);
        checkdup.setString(4, studKors);
        checkdup.setString(5, studGender);   

        ResultSet rs=checkdup.executeQuery();
    int dup=0;
        while (rs.next())
        {
        dup+=1;
        }  

    if (dup>1 ) {
        System.out.println("You entered a duplicate value!!. Try Again! ");         
        System.out.println("Take note that the entered Duplicate value is entered in the Database");
        System.out.println("Remove the duplicate value using delstud() method!!!");
    }

        con.close();
    }

    catch (Exception e) 
    {
        System.out.println("There is an error ");

    }