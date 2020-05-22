try
    {
           Class.forName("com.mysql.jdbc.Driver").newInstance();
    }
    catch (Exception e)
    {
        System.out.println("Error in Data base Driver:"+e);
    }
    try 
    {                   
        String url="jdbc:mysql://localhost:3306/ebookshop", "root", ""; 
        connection=DriverManager.getConnection(url,userName,pass);

    }
    catch (Exception e) 
    {           

        System.out.println("Error in database connection:"+e);


    }