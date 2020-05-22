<?php

$response = array();

if (isset($_GET['login']) && isset($_GET['password'])) {

$login = $_GET['login'];
$password = $_GET['password'];

require_once __DIR__ . '/db_connect.php';

$db = new DB_CONNECT();


$checkUser = mysql_query("Select * FROM user where login = '$login'");

 if(mysql_num_rows($checkUser)>0){

       $result = mysql_fetch_array($checkUser);
       $userpassword = $result["password"];
       $user_id = $result["user_id"];

       $response["success"] = 1;
       $response["message"] = $userpassword;
       $response["user_id"] = $user_id;
       echo json_encode($response);
 }

 else{
       $response["success"] = 0;
       $response["message"] = "User not found";
       echo json_encode($response);
 }
 }
else {
$response["success"] = 0;
$response["message"] = "Required field(s) is missing";

echo json_encode($response);
}

?>