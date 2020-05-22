<?php
$uName=$_POST['username'];
$pWord=$_POST['password'];

$squl = "SELECT * FROM `usr` WHERE `uE`='".$uName."' && `uP`='".$pWord."' LIMIT 1";
$query = mysql_query($squl);
if (mysql_num_rows($query) == 1)
{
    date_default_timezone_set('Africa/Johannesburg');

    while($rows = mysql_fetch_array($query)){
        $logincount=$rows['uLC'];
        $logincount=$logincount + 1;
        $uid=$rows['ID'];
    }
    $nowtime = date("Y-m-d H:i:s");
    $loginsql = "UPDATE `users` SET `uLC`=$logincount, `uLL`='$nowtime'";
    $query = mysql_query($loginsql);


    $login_ok = true;
} else {
    $login_ok = false;
}

if ($login_ok) {
    $response["success"] = 1;
    $response["message"] = "Login successful!"; 
    die("[".json_encode($response)."]");
} else {
    $response["success"] = 0;
    $response["message"] = "Invalid Credentials!";
    die("[".json_encode($response)."]");
}   
mysql_close($db);

header('Content-Type: text/html; charset=utf-8'); 
?>