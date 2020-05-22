private Function<Map.Entry<User, List<BusinessUser>>, UserManagementDTO> getPermissionForUser() {
    return user -> {
      UserManagementDTO dto = userManagementMapper.userToUserManagementDTO(user.getKey());
      dto.setAuthorities(user.getValue().stream().map(BusinessUser::getAuthority).collect(Collectors.toSet()));
      return dto;
    };
  }