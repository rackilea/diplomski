@Override
public List<Address> findAllAddress(int userId) {
    User user = userDAO.findOne(userId);
    if (user == null) {
        throw new BadRequestException("Invalid user id", 101);
    }
    List<Address> addresses = user.getAddresses();
    if (addresses == null || addresses.isEmpty()) {
        throw new BadRequestException("Address Not found", 102);
    }
    return addresses;
}