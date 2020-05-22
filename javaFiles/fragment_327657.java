String queryString
    = "from customer "
    + "where customer_city = ? "
    + "and customer_street = ? "
    + "and customer_name = ? ";
Query query = session.createQuery(queryString);
query.setString(0, "Harrison");
query.setString(1, "main");
query.setString(2, "Hayes");
List<Customer> customers = (List<Customer>) query.list();