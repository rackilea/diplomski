Vector<Command> v = new Vector<>();
    v.addElement(new ImplementedCommand1());
    v.addElement(new ImplementedCommand2());

    Command command1 = v.get(0);

    command1.myFunction("Hello");

    Command command2 = v.get(1);

    command2.myFunction("Hello2");