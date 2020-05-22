<?PHP   

$link = mysql_connect($host, $username, $password) or die("Connection ERROR");

$db = mysql_select_db("$db_name") or die ("CONNECTION ERROR");

$resTime = $_POST['time'];
$fname = $_POST['fname'];
$lname = $_POST['lname'];
$phone = $_POST['phone'];
$date = $_POST['date'];
$partyNum = $_POST['partyNum'];



$query = "INSERT INTO RESERVATION (DATE, FNAME, LNAME, NUMBERINPARTY, RESOTIME, PHONENUMBER) VALUES ('" .$date. "', '" .$fname. "', '" .$lname. "', '" .$partyNum. "', '" .$resTime. "', '" .$phone. "');"; 
?>