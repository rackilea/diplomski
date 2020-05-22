String startCmdLine = this.serverSettings.getPlayerTypeSetting("StartConfig");
int cmdEndPos = startCmdLine.indexOf("javaw.exe") + "javaw.exe".length();
String cmd = startCmdLine.substring(0, cmdEndPos);
String args = startCmdLine.substring(cmdEndPos);

Runtime.getRuntime().exec(new String[]{ cmd, args });