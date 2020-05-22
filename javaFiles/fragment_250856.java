<?php

//Parameters for connecting to the database
$hostname = "localhost";
$database_name = "dbname";
$username = "user";
$password = "pass";

//Connection String. If it fails causes error message
$connection = mysql_connect($hostname,$username,$password) or trigger_error(mysql_error(),E_USER_ERROR);

//Access the database
mysql_select_db($database_name, $connection);

/*Query to get number of cars and execute the query
 *If there is a problem with the query an error is returned */
$get_number_of_cars = "SELECT VehicleDetected FROM entry ";
$query_runner = mysql_query($get_number_of_cars) or die(mysql_error());
$counter = 0;

while($row = mysql_fetch_array($query_runner))
{
    $counter++;
}

echo $counter;
?>