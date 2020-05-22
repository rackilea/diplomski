Transaction t1 = Spring.createTransaction();
t1.begin();
try {
    //your first service method marked as @Transactional
    userService.saveUser(userDto);
    t1.commit();
} catch (Throwable t) {
    t1.rollback();
} finally {
    t1.close();
}
Transaction t2 = Spring.createTransaction();
t2.begin();
try {
    //your second service method marked as @Transactional
    roleService.saveRole(roleDto);
    t2.commit();
} catch (Throwable t) {
    t2.rollback();
} finally {
    t2.close();
}