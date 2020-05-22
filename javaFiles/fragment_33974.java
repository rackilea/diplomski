@Override
@Transactional
public List<User> findAllConnectionsForUserById(Integer userId) {
    Optional<User> _user = userRepository.findById(userId);
    // omitted exception handling...
    User user = _user.get();
    List<Connection> connections = user.getConnections();

    return connections.strea.map(Connection::getRelatingUser).collect(Collectors.toList());