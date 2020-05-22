public void setSelectedRow(String row ) throws SQLException {
dbconnect = new myDbConnection();
        ResultSet resultSet =null;
        System.out.print(row);
        resultSet = dbconnect.excuteQuery("SELECT id, area,location, status1 ,date1,insname,oname,bname,street,junction,INSPSITION,recname1 FROM pledges where id='"+row+"'");
while (resultSet.next()){
              id.setText(resultSet.getString(1));
                area.setText(resultSet.getString(2));
                location.setText(resultSet.getString(3));
                status.setText(resultSet.getString(4));
                date.setText(resultSet.getString(5));
                insname.setText(resultSet.getString(6));
                oname.setText(resultSet.getString(7));
                bname.setText(resultSet.getString(8));
                street.setText(resultSet.getString(9));
                junction.setText(resultSet.getString(10));
                insposition.setText(resultSet.getString(11));
                recname.setText(resultSet.getString(12));
            }
         }