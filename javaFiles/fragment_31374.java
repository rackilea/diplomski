try {
   User thingie = hibernateDao.findUserByEmail(email);
}
catch (CustomerNotFoundException cnfe) {
    // TODO some logic on failure
}