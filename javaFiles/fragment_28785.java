@Override
public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    User user = userRepo.findByEmail(email);

    if (user == null) {
        throw new UsernameNotFoundException("Not found!");
    }

    return user;
}