static void modify()
    {
    System.out.println("Enter employee ID");
        empid=sc.nextInt();
       try{
            con=Connection1.getConnection();
            stmt=con.createStatement();
            String d="select * from emp where empid='"+empid+"'";
            rs=stmt.executeQuery(d);

    while(rs.next()){

     //Getting column value from record by giving column no 
                System.out.println(rs.getString(1)); //line 1
    //Getting column value from record by giving column name,
                System.out.println(rs.getString("empid"));// line 2
    }
       }
       catch(SQLException e)
       {
           e.printStackTrace();
       }

    }