public enum Commands {

    UPDATE_USER(Type.ADMIN, UpdateUser.class),
    ADD_USER(Type.ADMIN, AddUser.class),
    ADMIN_ASSIGNMENT(Type.ADMIN, AdminAssignment.class),
    BAN_USER(Type.ADMIN, BanUser.class),
    CHANGE_STATUS(Type.ADMIN, ChangeStatus.class),
    REMOVE_USER(Type.ADMIN, RemoveUser.class),

    SELL_SHARES(Type.USER, SellShares.class),
    BUY_SHARES(Type.USER, BuyShares.class);

    public enum Type {
        ADMIN,
        USER;
    }

    public static List<Commands> getByType(Type type) {
        List<Commands> commands = new ArrayList<Commands>();
        for (Commands command : values()) {
            if (command.type.equals(type)) {
                commands.add(command);
            }
        }
        return commands;
    }

    private final Type type;

    private final Class<? extends Command> command;

    private Commands(Type type, Class<? extends Command> command) {
        this.type = type;
        this.command = command;
    }

    public Class<? extends Command> getCommand() {
        return command;
    }

    public Command newInstance() throws Exception {
        return command.newInstance();
    }

}