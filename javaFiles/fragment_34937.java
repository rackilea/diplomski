@Value
class UserPlainDto {
    long userId;
    long contactCount;
    ActionType actionType;
    long actionCount;
}

@Data
class UserDto {
    long userId;
    long contactCount;
    Map<ActionType, Long> actions = new HashMap<>();
}