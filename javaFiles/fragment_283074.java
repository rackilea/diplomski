string output = string.Empty;

try
{
    // Sets up our process, the first argument is the command
    // and the second holds the arguments passed to the command
    ProcessStartInfo ps = new ProcessStartInfo("bash");
    ps.Arguments = "-c 'firefox'";
    ps.UseShellExecute = false;

    // Redirects the standard output so it reads internally in out program
    ps.RedirectStandardOutput = true;

    // Starts the process
    using (Process p = Process.Start(ps))
    {
        // Reads the output to a string
        output = p.StandardOutput.ReadToEnd();

        // Waits for the process to exit must come *after* StandardOutput is "empty"
        // so that we don't deadlock because the intermediate kernel pipe is full.
        p.WaitForExit();
    }
}
catch
{
    // TODO manage errors
}