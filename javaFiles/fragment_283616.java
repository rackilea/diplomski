ResultSet searchRs = stmt.executeQuery(searchQuery);

//User name is available
if (searchRs.next() == false) {
    bean.setExists(false);
} 

//User name is not available
else if (searchRs.next() == true) {
    bean.setExists(true);
}

if (bean.getExists() == true) {
    //Return error and prevent registration
    bean.setSuccess(false);
    return bean;
}