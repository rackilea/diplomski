$Machines = Get-Content C:\Lists\Servers.txt

$Machines | for-each{

$java = gci '\\$_\c$\Program Files (x86)\Java\jre7\bin\java.exe'

$java.VersionInfo