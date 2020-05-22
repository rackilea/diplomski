try {
    // statements
} catch (MissingFieldException|EmptyFieldException|UnknownCardTypeException|UnknownSpellCardException ex) {
    logger.log(ex);
    throw ex;
}