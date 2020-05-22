try {
    userService.createUser("toto1");
    Assert.fail("expecting some AlreadyExistsException here")
} catch (AlreadyExistsException e) {
    // ignore
}

log.info("3");