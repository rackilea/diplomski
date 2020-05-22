import org.apache.commons.cli.*;

public class Main {


    public static void main(String[] args) throws Exception {

        Options options = new Options();

        Option host = new Option("h", "host", true, "host address");
        host .setRequired(true);
        options.addOption(host);

        Option user = new Option("u", "user", true, "user login");
        user.setRequired(true);
        options.addOption(user);

        Option password = new Option("p", "password", true, "user's password");
        password.setRequired(true);
        options.addOption(password);

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("my-program", options);

            System.exit(1);
            return;
        }

        String inputHost = cmd.getOptionValue("host");
        String inputUser = cmd.getOptionValue("user");
        String inputPassword = cmd.getOptionValue("password");


    }

}