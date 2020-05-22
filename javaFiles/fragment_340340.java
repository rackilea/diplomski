String[] cmd_exec = {};
String os_name = System.getProperty("os.name").toLowerCase();
if (os_name.indexOf("win") >= 0)
    cmd_exec = new String[]{"cmd.exe", "/c", cmd};
else if (os_name.indexOf("mac") >= 0)
    cmd_exec = new String[]{"/usr/bin/open", "-a", cmd};
else if (os_name.indexOf("nix") >= 0 || os_name.indexOf("nux") >= 0)
    cmd_exec = new String[]{"/bin/bash", cmd};
else if (os_name.indexOf("sunos") >= 0)
    cmd_exec = new String[]{"/bin/bash", cmd};

Process child = Runtime.getRuntime().exec(cmd_exec);

String line;
while ((line = stdInput.readLine()) != null)
{
    buffer.append("\t" + new String(line.getBytes("UTF-8"), "UTF-8") + "\n");
}
stdInput.close();
while ((line = stdError.readLine()) != null)
{
    buffer.append("\t" + new String(line.getBytes("UTF-8"), "UTF-8") + "\n");
}
stdError.close();

child.destroy();