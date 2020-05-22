public boolean validate(final String mail, final String password) 
                                                        throws ServiceException {
    try {
        final boolean valid;

        // Validate null and empty

        // Validate with DB
        final UserDAO dao = new UserDAO();
        final User user = dao.findByPk(mail);
        if (user == null) {
            valid = false;
        } else {
            if (password.equals(user.getPassword())) {
                valid = true;
            } else {
                valid = false;
            }
        }
        return valid;
    } catch (DAOException e) {
        throw new ServiceException("Error validating user and password.", e);
    }
}