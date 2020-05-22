@PreAuthorize("hasRole('list_users_permission')")
public List<UserDto> getAllUsers() {
    return doGetAllUsers();
}

public List<UserDto> doGetAllUsers() {
    ...
}