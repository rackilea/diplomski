//Init Lanterna terminal
Terminal terminal = TerminalFacade.createTerminal();
//Will bring up the terminal window
terminal.enterPrivateMode();
//Optional: you can hide the cursor so it wont blink
terminal.setCursorVisible(false);