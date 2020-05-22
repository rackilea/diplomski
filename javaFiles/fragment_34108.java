for(int q=1;q<=p;q++)
    {

   Document document=new Document(); 

    PdfWriter.getInstance(document,new FileOutputStream("c:/temp/salary.pdf"));
    document.open(); 

     PdfPTable table = new PdfPTable(2);
    table.addCell("eid"); 
    table.addCell("salary");

     Statement st3= con.createStatement();

  ResultSet rs = st3.executeQuery("select * from salary where eid ='"+q+"'");
     while(rs.next())
     {
         table.addCell(rs.getString("eid"));
         table.addCell(rs.getString("salary")); 
    }
     document.add(table);
         document.close();
         }
    }