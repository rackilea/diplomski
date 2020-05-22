System.Diagnostics; ... ProcessStartInfo _processStartInfo = new ProcessStartInfo();
_processStartInfo.WorkingDirectory = @"%ProgramFiles%";
_processStartInfo.FileName = @"Notepad.exe"; 
_processStartInfo.Arguments = "test.txt"; 
_processStartInfo.CreateNoWindow = true;
Process myProcess = Process.Start(_processStartInfo);