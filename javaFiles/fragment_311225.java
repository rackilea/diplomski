interface Command {
        void execute();
    }

    enum MyEnum implements Command {
        A() {
            public void execute() {
                System.out.println("A");
            }
        },
        B {
            public void execute() {
                System.out.println("B");
            }
        };
    }