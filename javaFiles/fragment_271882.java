int pid = (some code to extract PID from the process you want to kill);
Win32Process process = new Win32Process(pid);
kill(process);

public void kill(Win32Process target) throws IOException
{
   List<Win32Process> children = target.getChildren ();
   target.terminateProcess ();
   for (Win32Process child : children) kill(child);
}