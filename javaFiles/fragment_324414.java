// Other codes
 try { 
        String[] quantity = request.getParameterValues("Quantity_field");
        java.util.Date selectedDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("deliveryDate")); 
        java.util.Date selectedTime = new SimpleDateFormat("hh:mm:ss").parse(request.getParameter("deliveryTime")); 
        // Add the lines below
        java.sql.Date selectedSQLDate =  new java.sql.Date(selectedDate.getTime());
        java.sql.Time selectedSQLTime =  new java.sql.Time(selectedTime.getTime());
        con = DBConnection.createConnection();
        statement = con.createStatement();
        String query = " insert query  VALUES   (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(query);
        for (int i = 0; i < quantity.length; i++) {
            if (Double.parseDouble(quantity[i]) != 0) {
                if(recorderNo!=0)
                {
                    ps.setInt(1, recorderNo);
                }
                else
                {
                    ps.setInt(1, 1);
                }

                ps.setDate(2, dateSql);
                ps.setString(3, 77);
                ps.setDouble(4, 55);
                ps.setInt(5, 0);
                ps.setInt(6, 0);
                ps.setDouble(7, Double.parseDouble(quantity[i]));
                ps.setInt(8, 0);
                ps.setInt(9, 0);
                ps.setInt(10, 0);
                ps.setString(11, outlet);
                ps.setTimestamp(12, timestamp);
                ps.setDate(13,selectedDate); // here i am trying to put date
                ps.setTime(14,selectedTime);// and here time
                ps.addBatch();
            }
        }
        ps.executeBatch();
        // Other codes

} catch (Exception e){
       // TODO Auto-generated catch block 
}