@Override
    public void editUser(final User user) {
        UserDocument userDocument = this.usersRepository.findByIdAndActivo(user.getId(), true)
                .orElseThrow(UserNotFoundException::new);

        this.modelMapper.map(user, userDocument);
        this.usersRepository.save(userDocument);
    }