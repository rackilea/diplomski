try {

      ResultSet rs3 = db.getData("SELECT qty FROM invoice WHERE inid='"  +   rs1.getInt("inid") + "'");
int total=0;
       while(rs3.next()){
       total+=rs3.getInt("qty");
      }
System.out.println(total);

  }

  catch (Exception e) {

          JOptionPane.showMessageDialog(null, this.getClass().getName() + "rs2 " + e);
  }