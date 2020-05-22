private static string javaHome;

protected static string JavaHome
{
    get
    {
        string home = javaHome;
        if (home == null)
        {
            home = Environment.GetEnvironmentVariable("JAVA_HOME");
            if (string.IsNullOrEmpty(home) || !Directory.Exists(home))
            {
                home = CheckForJavaHome(Registry.CurrentUser);
                if (home == null)
                    home = CheckForJavaHome(Registry.LocalMachine);
            }

            if (home != null && !Directory.Exists(home))
                home = null;

            javaHome = home;
        }

        return home;
    }
}

protected static string CheckForJavaHome(RegistryKey key)
{
    using (RegistryKey subkey = key.OpenSubKey(@"SOFTWARE\JavaSoft\Java Development Kit"))
    {
        if (subkey == null)
            return null;

        object value = subkey.GetValue("CurrentVersion", null, RegistryValueOptions.None);
        if (value != null)
        {
            using (RegistryKey currentHomeKey = subkey.OpenSubKey(value.ToString()))
            {
                if (currentHomeKey == null)
                    return null;

                value = currentHomeKey.GetValue("JavaHome", null, RegistryValueOptions.None);
                if (value != null)
                    return value.ToString();
            }
        }
    }

    return null;
}