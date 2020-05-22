MyApp app = new MyApp();
StringWriter sw = new StringWriter();
CommandLine cmd = new CommandLine(app);
cmd.setOut(new PrintWriter(sw));

// black box testing 
int exitCode = cmd.execute("-x", "-y=123");
assertEquals(0, exitCode);
assertEquals("Your output is abc...", sw.toString());

// white box testing 
assertEquals("expectedValue1", app.getState1());
assertEquals("expectedValue2", app.getState2());