# Download an extract IKVM to any folder
# cd C:\temp\ikvm\bin\
# convert jar to dll with ikvmc: ikvmc -target:library C:\jdbc\ojdbc6.jar


Add-Type -Path "C:\temp\ikvm\bin\ojdbc6.dll"
Add-Type -Path "C:\temp\ikvm\bin\IKVM.OPenJDK.Jdbc.dll"
Add-Type -Path "C:\temp\ikvm\bin\IKVM.OPenJDK.Core.dll"

$url = "jdbc:oracle:thin:@localhost:1521/someServiceName"
$driver = [oracle.jdbc.driver.OracleDriver]::new()
$props = [java.util.Properties]::new()
$props.setProperty("user", "someUser")
$props.setProperty("password", "somePassword")
$conn = $driver.connect($url, $props) 
$cmd = $conn.createStatement()

$r = $cmd.executeQuery("select * from all_tables where rownum < 20")
Write-Host "column count: $($r.getMetaData().getColumnCount())"

while($r.next()){

$row = foreach($c in 1..20){ $r.getString($c)}
Write-Host ($row -join "|")
}