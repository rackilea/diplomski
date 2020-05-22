while (resultSet.next())
{
    customer.customerOrders.add(resultSet.getString(3));
    customer.customerAddresses.add(resultSet.getString(4));
    customer.customerTelephoneNumbers.add(resultSet.getString(5));
}