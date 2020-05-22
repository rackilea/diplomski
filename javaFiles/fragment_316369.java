Environment.SetEnvironmentVariable("JAVA_PRG", @"d:\temp"); // Whatever
Process process = new Process();
ProcessStartInfo startInfo = new ProcessStartInfo();
startInfo.WorkingDirectory = Path.Combine(javaPath, "bin");
startInfo.FileName = "cmd.exe";
if (chbPath.Checked) 
    startInfo.Arguments = "/C java.exe .... -jar %JAVA_PRG%\SecondDimension.jar ";