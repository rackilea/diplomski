@Override
@Transactional
public void save(User user) {
    user.setRol(roleDao.getOne(1l));
    userDAO.save(user);
}