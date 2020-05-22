preparedStatement = connection.prepareStatement("INSERT INTO customer 
                         (cust_ID, sale_ID, first_Name, mI, last_Name, street_Name, city, state, zip_Code, DOB, agent_ID, home_Phone, cell_Phone, profession, employer, referrer)"
                    + " VALUES 
                         (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
preparedStatement.setLong(1, Long.valueOf(custID));
preparedStatement.setLong(2, Long.valueOf(saleID));
preparedStatement.setString(3, firstName);
// ...
preparedStatement.executeUpdate();