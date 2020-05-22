class MyExtendedClass extends MyClass {

    enum MyExtendedCommands implements Command {

        bCmd {
            public void execute() {/* do something */
            }

            public String getId() {
                return name();
            }
        }
    }

    public void myMethod(String s){
        Set<Command> allCommands = new HashSet<>();
        allCommands.addAll(EnumSet.allOf(MyCommands.class));
        allCommands.addAll(EnumSet.allOf(MyExtendedCommands.class));

        for(Command cmd: allCommands){
            if(s.equals(cmd.getId())) cmd.execute();
        }
    }
}