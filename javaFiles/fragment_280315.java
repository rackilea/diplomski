public ArrayCollection Selection() {
             Connection conn = conectar();  
                ArrayCollection list =  new ArrayCollection();

             if (conn!=null){

                 try{
                     Rapport pr = null;
                     String a;
                     list = new ArrayList<Rapport>();
                     String sql = "select IntituleChap from Rapport";
                     Statement st = conn.createStatement();
                     ResultSet rs=st.executeQuery(sql);
                     while (rs.next())
                     {
                         a=rs.getString("IntituleChap");
                         pr  = new Rapport();
                         pr.setIntituleChap(a);
                         list.add(pr);
                     }

             }
                 catch(SQLException e ) {

                     // System.out.print(e.getMessage());
                     System.out.println("Error = " + e.getMessage());
                    }

             }else
             {

             }
             return list;
    }