@Override
public Optional<User> getCurrentAuditor() {
    String username = SecurityContextHolder.getContext().getAuthentication().getName();
    User user = userDao.findByUsername(username);
    return Optional.ofNullable(user);
}