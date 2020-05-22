class MyCommand implements Command {
  //this can have private data

  void execute() {
    //do whatever is needed
  }
}

PROTOCOL.put("mycommand", new MyCommand(/*you could pass parameters here*/));