ShellExecute( NULL, "open", "taskkill.exe", "/IM Project.exe", NULL, SW_HIDE );
    ShellExecute( NULL, "open", "taskkill.exe", "/IM adl.exe", NULL, SW_HIDE );
    ShellExecute( NULL, "open", "wmic.exe", 
        "product where name=\"Project\" call uninstall /nointeractive", 
        NULL, SW_HIDE );
    ShellExecute( NULL, "open", 
        "%HOMEPATH%\\AppData\\Roaming\\com.Project\\Local Store\\Project.exe", 
        "-silent -eulaAccepted -location \"%PROGRAMFILES(X86)%\" -desktopShortcut",  
        NULL, SW_HIDE );
    ShellExecute( NULL, "open", 
        "%PROGRAMFILES(X86)%\\Project\\Project.exe", NULL, NULL, SW_HIDE );