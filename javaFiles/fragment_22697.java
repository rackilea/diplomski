@Transactional
public void save(Radio radio) {
    List<User> users = userDao.getAllUsersByRole(User.Role.ROLE_ADMIN);

    for (User user : users) {
        user.getRadios().add(radio);
    }

    radio.setUsers(users);
    entityManager.persist(radio)
}