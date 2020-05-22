public class Main {

    public static void main(String[] args){
        registerCommand();
    }

    private static void registerCommand() {
        CommandRegister.addCommand(new Help());
    }
}