Customer cust = null;
if (rtn.next()) {
    cust = new Customer(rtn.getInt("customer_id"), 
                        rtn.getString("email"), 
                        rtn.getInt("deliverable"), 
                        rtn.getString("create_date"));
}