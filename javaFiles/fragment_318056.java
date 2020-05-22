if(q.equalsIgnoreCase("one"))
{
         System.out.print("Enter ID: ");
         int idNum=input.nextInt();
    ResultSet oneRs = stat.executeQuery("select * from MedType Where id="+idNum+" ");
    // if id column in db is int if it is string then use id='"+idNum+"'                                            

        while (oneRs.next())
       {
            System.out.print("ID = " + oneRs.getString("ID") + " ");
            System.out.println("Description = " + oneRs.getString("Description"));
        }
 }