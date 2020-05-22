Customer custemer;

if (resultSet.next()) {
   customer = new Customer(resultSet.getInt("customerid"));
}

return custemer;