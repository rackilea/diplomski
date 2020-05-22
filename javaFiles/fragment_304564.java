[Files]
Source: "J:\mysql-5.5.11-win32.msi"; DestDir: "{tmp}"; Flags: nocompression dontcopy

[Run]
Filename: "{reg:HKLM\SOFTWARE\MySQL AB\MySQL Server 5.5,Location}\bin\mysqld.exe"; 
  Parameters: "--install"; WorkingDir: "{reg:HKLM\SOFTWARE\MySQL AB\MySQL Server 5.5,Location}\bin"; 
  StatusMsg: "Sto installando il Servizio MySQL"; 
  Description: "Installing MySQL Service"; 
  Flags: runhidden; Check: MySQL_Is
;//and the rest of commands

[Code]
function MySQL_Is(): Boolean;
var
iResultCode: Integer;
begin
  Result := true;
  if (not RegKeyExists(HKLM, 'SOFTWARE\MySQL AB\MySQL Server 5.5')) or 
   (not FileExists(ExpandConstant('{reg:HKLM\SOFTWARE\MySQL AB\MySQL Server 5.5,Location}\bin\mysql.exe'))) 
  then begin
     ExtractTemporaryFile('mysql-5.5.11-win32.msi');
     Exec('msiexec.exe', '/i mysql-5.5.11-win32.msi /qn INSTALLDIR="C:\mysql"', 
      ExpandConstant('{tmp}'), SW_HIDE, ewWaitUntilTerminated, iResultCode);
         if not FileExists(ExpandConstant('{reg:HKLM\SOFTWARE\MySQL AB\MySQL Server 5.5,Location}\bin\mysql.exe')) then begin
            MsgBox('Something went wrong! Installation should be terminated', 
              mbInformation, MB_OK);
            Result := false;
         end;
  end;
end;