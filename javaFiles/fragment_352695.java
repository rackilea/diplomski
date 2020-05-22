class MyClass {
    interface Command {
        void execute();

        String getId();
    }

    enum MyCommands implements Command {

        aCmd {
            public void execute() {/* do something */
            }

            public String getId() {
                return "aCmd";
            }
        }
    }

    public void myMethod(String s) {
        for (Command cmd : EnumSet.allOf(MyCommands.class)) {
            if (s.equals(cmd.getId()))
                cmd.execute();
        }
    }
}