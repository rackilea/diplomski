try
{
    BufferedReader br=new BufferedReader(new FileReader("v.csv"));
    String line;

    db = DatabaseConnection.ConnectDB();
    while((line=br.readLine())!=null){
        System.out.println(line);
        String[]value = line.split(",");
        System.out.println(value.length);

        String sql = "INSERT into main ([Ticket #], Status, Priority, Department, [Account Name]) "
         + "values ('"+value[0]+"','"+value[1]+"','"+value[2]+"','"+value[3]+"','"+value[4]+"')";

        System.out.println("test");

        PreparedStatement pst = null;
        try{   
          pst = db.prepareStatement(sql);
          pst.executeUpdate();
        }finally{
          if(pst != null) {
            pst.close();
          }
        }
    }
    br.close();
}
catch(Exception e)
{
    JOptionPane.showMessageDialog(null, e);
}