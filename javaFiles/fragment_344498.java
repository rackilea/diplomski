public static void main(String[] args) {
        if (args.length > 0 && args[0].equalsIgnoreCase("web"))
            SpringApplication.run(CommServerStarter.class, args);
        else
            startConsole(args);
    }

    public static void startConsole(String[] args) {
        ...
    }
}