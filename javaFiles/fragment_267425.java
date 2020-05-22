function Invoke-Jdbc { param(
  $java="Java" # or path to java exe 
, $format="EXCEL"
, $driver = "C:\jdbc\jdbcsql.zip"
, $dbtype, $hostname, $port, $db, $user, $password, $query
)

$data = &$java -jar $driver -f $format -m $dbtype -host $hostname -port $port -d $db -U $user -P $password $query
Write-Output -NoEnumerate ($data | ConvertFrom-Csv -Delimiter "`t" | Out-DataTable)

}


$oracle = @{ 
 dbtype = "oracle"
 hostname = "localhost"
 port = "1521"
 db = "ServiceNameOrSID"
 user = "user"
 password = "password"
 query = "select owner, table_name from all_tables"
}

$dt = Invoke-JDBC @oracle