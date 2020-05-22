processRequest() {
    ...
    try {
      createOrder();
    } catch (SaveNotAllowedException e) {
        // Handle the expected problem
        ...
        log.info("Save was not allowed...");
    }

    try {
      backupOrder();
    } catch (AnotherException e) {
        ...
    }       
}

@Transactional(rollbackFor = SaveNotAllowedException.class)
createOrder() throws SaveNotAllowedException {
    ...
    saveRow();
}

@Transactional(rollbackFor = AnotherException.class)
backupOrder() throws AnotherException {
    ...
}

@Transactional
saveRow() throws SaveNotAllowedException {
    // Updating row in database is not allowed because of some business condition
    throw new SaveNotAllowedException();
}