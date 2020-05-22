try
    {
       java.sql.Statement statement.execute(q);
    }
    catch (SQLException e){
         System.out.println("DB Exception"); // Put breakpoint here
         e.printStackTrace(); 
    }
    catch(Exception e)
    {
         System.out.println("General Exception"); // Put breakpoint here
         e.printStackTrace(); 
    }