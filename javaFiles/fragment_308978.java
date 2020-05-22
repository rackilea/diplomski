public void updateUserTitle(User user, String newTitle) {
    PersistenceManager pm = PMF.get().getPersistenceManager();
    try {
        User e = pm.getObjectById(User.class, user.getId());

            e.setTitle(newTitle);
        } finally {
        pm.close();
    }
}