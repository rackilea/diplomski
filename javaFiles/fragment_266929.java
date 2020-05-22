CommandStack stack = new CommandStack();

stack.doCommand(new AddFriendCommand("Jim"));
stack.doCommand(new AddFriendCommand("Bill"));
stack.doCommand(new AddFriendCommand("Jill"));
stack.doCommand(new RemoveFreindCommand("Jim"));

stack.undo();
stack.undo();