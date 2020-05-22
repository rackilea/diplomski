<?php
$db_name="citizen";
$mysql_user="root";
$mysql_pass="";
$server_name="localhost";

$con=mysqli_connect($server_name,$mysql_user,$mysql_pass,$db_name);

if($con)
{
echo"Connection success...";
}
else
{
echo"Connection failed...";
}

?>