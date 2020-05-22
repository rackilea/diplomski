# variable 'code' is for JDK version code from registry.
# Uninstall comand: MsiExec.exe /quiet /X[CODE]
# Codes are in regkey HKEY_LOCAL_MACHINE\SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall. Be aware to check key for JDK, not JRE!

remove_command = "MsiExec.exe /quiet /X#{code}"

execute "Remove JDK from system" do
        command         remove_command
        returns         [0,1605]  # 1605 for non-existing product error
end