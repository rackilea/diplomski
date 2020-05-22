@Override
@Transactional
public User registerUser(User user) {
    List<Role> roles = new LinkedList<>();
    roles.add(new Role("USER"));
    user.setRoles(roles);
    return userRepository.save(user);
}}