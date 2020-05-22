string javaDirectory = null;

// Native registry key - 32b on 32b or 64b on 64b
// Fall back on 32b Java on Win64 if available
RegistryKey javaKey =
    Registry.LocalMachine.OpenSubKey("SOFTWARE\\Javasoft\\Java Runtime Environment") ??
    Registry.LocalMachine.OpenSubKey("SOFTWARE\\Wow6432Node\\Javasoft\\Java Runtime Environment");

if (javaKey != null)
{
    string javaVersion = javaKey.GetValue("CurrentVersion").ToString();
    try
    {
        javaDirectory = javaKey.OpenSubKey(javaVersion).GetValue("JavaHome").ToString();
    } catch(NullReferenceException)
    { /* Ignore null deref, means we can't get a directory */ }
}

if (javaDirectory == null)
{
    // deal with a lack of Java here.
}