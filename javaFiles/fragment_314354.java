[Registry]
; Create the application capability key
Root: HKLM; Subkey: "Software\My Company"; Flags: uninsdeletekeyifempty
Root: HKLM; Subkey: "Software\My Company\My Program"; Flags: uninsdeletekeyifempty
Root: HKLM; Subkey: "Software\My Company\My Program\Capability"; \
    ValueType: string; ValueName: "ApplicationDescription"; \
    ValueData: "This is My Program that does stuff"; Flags: uninsdeletevalue
Root: HKLM; Subkey: "Software\My Company\My Program\Capability"; \
    ValueType: string; ValueName: "ApplicationName"; ValueData: "My Program"; \
    Flags: uninsdeletevalue
; List of extensions the application supports
Root: HKLM; Subkey: "Software\My Company\My Program\Capability\FileAssociations"; \
    ValueType: string; ValueName: ".jpg"; ValueData: "MyProgram.JPEG"; \
    Flags: uninsdeletevalue

; Add the capability key to list of registered applications
Root: HKLM; Subkey: "Software\RegisteredApplications"; \
    ValueType: string; ValueName: "My Program"; \
    ValueData: "Software\My Company\My Program\Capability"; \
    Flags: uninsdeletevalue

; For each extension that the application supports
Root: HKCR; Subkey: "MyProgram.JPEG"; Flags: uninsdeletekeyifempty
Root: HKCR; Subkey: "MyProgram.JPEG"; \
    ValueType: string; ValueName: ""; ValueData: "MyProgram JPEG"; Flags: uninsdeletevalue
Root: HKCR; Subkey: "MyProgram.JPEG\DefaultIcon"; Flags: uninsdeletekeyifempty
Root: HKCR; Subkey: "MyProgram.JPEG\DefaultIcon"; \
    ValueType: string; ValueName: ""; ValueData: "{app}\MyProg.exe,1"; \
    Flags: uninsdeletevalue
Root: HKCR; Subkey: "MyProgram.JPEG\Shell"; Flags: uninsdeletekeyifempty
Root: HKCR; Subkey: "MyProgram.JPEG\Shell\open"; Flags: uninsdeletekeyifempty
Root: HKCR; Subkey: "MyProgram.JPEG\Shell\open\Command"; Flags: uninsdeletekeyifempty
Root: HKCR; Subkey: "MyProgram.JPEG\Shell\open\Command"; \
    ValueType: string; ValueName: ""; ValueData: """{app}\MyProg.exe"" ""%1"""; \
    Flags: uninsdeletevalue