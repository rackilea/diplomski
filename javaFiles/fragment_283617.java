// Check the true condition first, no need for == true
if (searchRs.next()) {
    // User already exists
    bean.setExists(true);
    bean.setSuccess(false);

    // Returning the bean object isn't strictly necessary because of side-effects
    return bean;
} else {
    // User doesn't already exist
    bean.setExists(false);
    stmt.executeUpdate(insertQuery);

    // You'll need to commit the transaction for it to work properly:
    currentCon.commit();
    bean.setSuccess(true);

    return bean;
}