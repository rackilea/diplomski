this.roleCheckboxes = roles.stream()
        .map(role ->
                new RoleCheckbox(
                        role,
                        user.getUserRoles().stream()
                                .anyMatch(userRole -> userRole.getRole() == role)
                )
        )
        .collect(Collectors.toList());