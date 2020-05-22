class ClientDao {
    insert(@Valid Client c) throws DaoException, MyValidationException {
        try {
            myEntityManagerOrAnyPersistenceStrategy.insert(c);
        } catch (ConstraintViolationException ex) {
            throw new MyValidationException(...);
        }
    }
}