[Files]
Source: "MyApp.jar"; DestDir: "{app}"
Source: "lib\*.jar"; DestDir: "{app}\lib"

#define ProcessFile(Source, FindResult, FindHandle) \
    Local[0] = FindGetFileName(FindHandle), \
    Local[1] = Source + "\\" + Local[0], \
    Local[2] = FindNext(FindHandle), \
    "'" + Local[0] + "'#13#10" + \
        (Local[2] ? ProcessFile(Source, Local[2], FindHandle) : "")

#define ProcessFolder(Source) \
    Local[0] = FindFirst(Source + "\\*.jar", faAnyFile), \
    ProcessFile(Source, Local[0], Local[0])

#define DepedenciesToInstall ProcessFolder("lib")
#define DependenciesLog "{app}\dependencies.log"

[UninstallDelete]
Type: files; Name: "{#DependenciesLog}"