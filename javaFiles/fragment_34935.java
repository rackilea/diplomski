default Collection<UserDto> getReport() {
    Map<Long, UserDto> result = new HashMap<>();

    getUserPlainDtos().forEach(dto -> {
        long userId = dto.getUserId();
        long actionCount = dto.getActionCount();

        UserDto userDto = result.getOrDefault(userId, new UserDto());
        userDto.setUserId(userId);
        userDto.setContactCount(dto.getContactCount());
        userDto.getActions().compute(dto.getActionType(), (type, count) -> count != null ? count + actionCount : actionCount);
        result.put(userId, userDto);
    });

    return result.values();
}