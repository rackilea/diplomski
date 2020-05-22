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

        while (rs.next())
        {
            boolean dup1=rs.getObject(2).equals(studName);
            boolean dup2=rs.getObject(3).equals(studNum);
            boolean dup3=rs.getObject(4).equals(studYrLvl);
            boolean dup4=rs.getObject(5).equals(studKors);
            boolean dup5=rs.getObject(6).equals(studGender);

            System.out.println("The name you entered is: " + dup1 + " The student number you entered is: " + dup2 + " The Yr/Lvl you entered: " + dup3 + " The Course you entered: " + dup4 + " The Sex you entered is: " + dup5);

        }  

        con.close();
    }

    catch (Exception e) 
    {
        System.out.println("You entered a duplicate value!!. Try Again! ");
        System.out.println("Take note that the entered Duplicate value is entered in the Database");
        System.out.println("Remove the duplicate value using delstud() method!!!");

    }