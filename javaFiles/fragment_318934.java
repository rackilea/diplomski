UserActionFactory factory = new UserActionFactory();
ScannerWrapper sw = new ScannerWrapper();

while (true) {
    menuHeader();
    int choice = sw.readInt();
    UserAction action = factory.make(choice);
    action.execute();