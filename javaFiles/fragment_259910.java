string installPath = GetJavaInstallationPath();
string filePath = System.IO.Path.Combine(installPath, "bin\\Java.exe");
if (System.IO.File.Exists(filePath))
{
    // We have a winner
}