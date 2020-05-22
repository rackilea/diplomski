AbstractSVNCommand.registerCommand(new SVNStatusCommand());

final ByteArrayOutputStream bos = new ByteArrayOutputStream();
final PrintStream stream = new PrintStream(bos);

final SVNCommandLine commandLine = new SVNCommandLine();
commandLine.init(new String[] {"status", "d:/svntest/small.svn17"});

final SVNCommandEnvironment env = new SVNCommandEnvironment("mySvn", stream, stream, System.in);
env.init(commandLine);
env.initClientManager();

final SVNStatusCommand svnStatusCall = new SVNStatusCommand();
svnStatusCall.init(env);
svnStatusCall.run();
stream.flush();
System.out.println(new String(bos.toByteArray()));