try {
    // Your database access code here
} catch (SQLException e) {
    // You don't want to persist any dud data, so rollback the connection
    currentCon.rollback();

    // Propagates the exception upward to the calling method
    throw new RegistrationException("Error registering user", e);
}