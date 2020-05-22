Dbconnection obj=new Dbconnection();
        rs=obj.getWorkers();// rs is ResultSet object And getWorkers() is just a method in class Dbconnection
        Vector v1=new Vector();
        v1.addElement("ID");   //column name in JTable
        v1.addElement("NAME"); //column name in JTable
        v1.addElement("STATE"); //column name in JTable
        v1.addElement("MOB");   //column name in JTable
        Vector v3=new Vector(); //column name  in JTable 
        try{
        while(rs.next())
        {
            Vector v2=new Vector();
            v2.addElement(rs.getString(8));  // 8 is column number,And it depends on your query 
            v2.addElement(rs.getString(2));  // 2 is column number,And it depends on your query
            v2.addElement(rs.getString(6));  // 6 is column number,And it depends on your query
            v2.addElement(rs.getString(7)); // 7 is column number,And it depends on your query
        v3.add(v2);
        }
        }catch(Exception e){}
        JTable wrkr_table=new JTable(v3, v1);
        wrkr_table.setBackground(Color.PINK);
        JScrollPane scp=new JScrollPane(wrkr_table);
        scp.setBounds(50,100,680,110);
        frame.add(scp);