private string GetJavaInstallationPath()
{
    string environmentPath = Environment.GetEnvironmentVariable("JAVA_HOME");
    if (!string.IsNullOrEmpty(environmentPath))
    {
       return environmentPath;
    }

    string javaKey = "SOFTWARE\\JavaSoft\\Java Runtime Environment\\";
    using (Microsoft.Win32.RegistryKey rk = Microsoft.Win32.Registry.LocalMachine.OpenSubKey(javaKey))
    {
        string currentVersion = rk.GetValue("CurrentVersion").ToString();
        using (Microsoft.Win32.RegistryKey key = rk.OpenSubKey(currentVersion))
        {
            return key.GetValue("JavaHome").ToString();
        }
    }
}