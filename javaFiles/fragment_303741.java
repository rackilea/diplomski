custInfo = new CustomerInfo();
custInfo.UserID = resultSet.getString("USERID");
custInfo.FirstName = resultSet.getString("FIRSTNAME");
custInfo.SecondName = resultSet.getString("SECONDNAME");

customerList.add(custInfo);