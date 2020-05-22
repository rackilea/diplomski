Class<Command> klass = (Class<Command>) Class.forName(
    "main.Commands " +
    String.valueOf(command.toCharArray([0]).toUpperCase() +
    command.substring(1).toLowerCase()
);

Command x = klass.newInstance();