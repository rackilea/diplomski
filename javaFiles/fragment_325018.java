List<Customer> listCustemer = new ArrayList<>();

while (resultSet.next()) {
   listCustemer.add(new Customer(resultSet.getInt("customerid")));
}

return listCustemer;