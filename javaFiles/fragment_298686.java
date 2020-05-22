Optional.ofNullable(studentsByCourseRoster.getUsers())
        .orElse(Collections.emptyList())
        .forEach(user -> {
                     final UserDTOv2 userDTO = new UserDTOv2();
                     userDTO.populateUserDataFromUserDTO(user, groupedUsers);
                     users.add(userDTO);
         });