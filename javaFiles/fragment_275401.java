import com.fasterxml.jackson.core.io.JsonStringEncoder;

JsonStringEncoder e = JsonStringEncoder.getInstance();
String commands = "ls -laF\\ndu -h";
String encCommands = new String(e.quoteAsString(commands));
String o = "{commands: \"" + encCommands + "\", id: 0, timeout: 0}"