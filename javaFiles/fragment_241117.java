ResultSet rs = stmt.executeQuery(loginSQL);
    if(rs.next()){
    //If record exists as per updated query
    String mycase=rs.getString("userName");
         switch (mycase){//fetch Username
           case "SystemManager":
               response.sendRedirect("SystemManager.jsp");
               System.out.println("Welcome SystemManager ");
               break;
            case "Secretary":
               response.sendRedirect("Secretary.jsp");
               System.out.println("Welcome Secretary ");
               break;

             case "TeamLeader":
               response.sendRedirect("TeamLeader.jsp");
               System.out.println("Welcome TeamLeader ");
               break;

             case "WorkOrganizerLeader":
                response.sendRedirect("WorkOrganizerLeader.jsp");
               System.out.println("Welcome WorkOrganizerLeader ");
               break;

             case "ProjectManager":
               response.sendRedirect("ProjectManager.jsp");
               System.out.println("Welcome ProjectManager ");
               break;

             default :
                 System.out.println("I don't know you ...  ");

       } 
   }
   else{
     System.out.println("Get Out ...  : ");
    }
     rs.close();
     stmt.close();
     conn.close();