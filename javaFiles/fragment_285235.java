PreparedStatemet stat=null;
  PreparedStatement innerStat=null;
  PreparedStatement insertStat=null;

  try { 
     stat=conn.prepareStatement("select * from details where COURSEANDDEPT=?");
     stat.setString(1,username);

     ResultSet rs = stat.executeQuery();
     //if (rs.next()) {    
        while (rs.next()) {
            String logid=rs.getString(1);
            char temp=' ';
            innerStat=conn.prepareStatement("select type from login");
            ResultSet ag=innerStat.executeQuery();

            if (ag.next()) {
                temp=ag.getString(1).charAt(0);
                if (temp=='s' || temp=='S') {
                    String logid=ag.getString(1);
                    ag.close();
                    innerStat.close();
                    insertStat=conn.prepareStatement("insert into assignments values(?,?,?,?,?)");
                    insertStat.setString(1,logId);
                    insertStat.setString(2,comments);
                    insertStat.setString(3,"P");
                    insertStat.setString(4,userid);
                    insertStat.setString(5,username);

                    insertStat.executeUpdate();
                    insertStat.close();


                }//closes if on temp
            }  //closes if on ag
        } //closes while
        rs.close();
        stat.close();
            JOptionPane.showMessageDialog(this,"Assignment Sent To The Whole Class");
        //} else {
            //JOptionPane.showMessageDialog(this,"Invalid Branch");
        //}
  } catch (ClassNotFoundException | SQLException ex) {
    Logger.getLogger(Assignments.class.getName()).log(Level.SEVERE, null, ex);
     if(insertStat!=null) insertStat.close();
     if(innerStat!=null) innertStat.close();
     if(stat!=null) stat.close();
 }