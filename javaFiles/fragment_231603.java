$value = $_GET['value']; // this will retrieve the value from the url and save it in a variable

mysql_connect("localhost","root","");

// escape the value first
$value = mysql_real_escape_string($value);


mysql_select_db("imammuda");
$result = mysql_query("insert into Video (value) values ('$value')");

?>