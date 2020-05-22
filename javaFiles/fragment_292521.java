public class Dispatcher {

    public static final int SUCCESS = 0;

    public static final int FAILURE = 1;

    public static final Command HELP = (args) -> {
        String command = args[0];
        System.out.println("Usage of " + command + ": bla bla");
        return FAILURE;
    };

    public static final Command RENAME = (args) -> {
        File oldName = new File(args[1]);
        File newName = new File(args[2]);
        return oldName.renameTo(newName) ? SUCCESS : FAILURE;
    };

    public final Map<String, Command> commands = new HashMap<String, Command>() {{
        put("help", HELP);
        put("rename", RENAME);
    }};

    public int dispatch(String commandLine) {
        String[] args = commandLine.split("\\s");
        return Optional.ofNullable(commands.get(args[0]))
                .orElse(HELP)
                .execute(args);
    }
}

interface Command {
    int execute(String... args);
}