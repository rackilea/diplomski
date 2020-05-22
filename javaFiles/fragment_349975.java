public class CommandMain {

    public static void main(String[] args) {
        JCommander jc = new JCommander();
        jc.setProgramName(CommandMain.class.getSimpleName());
        FooCommand foo = new FooCommand();
        jc.addCommand("foo-command", foo);
        // display the help
        jc.usage();
    }
}