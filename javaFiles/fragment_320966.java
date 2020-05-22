<?php
$val  =file_get_contents('php://input');
$jsonObj = json_decode($val);
$jsonObj  = (object)$jsonObj;
$data1 = $jsonObj->yourkey;
$data2 = $jsonObj->yourkey;

// your sql execution

$returnData = array(
    "code"  => 500,
    "msg"   => "UserName Already Exist!! Try with diffrent user Name!!",
    );
$a = json_encode($returnData);
echo $a;
die();

?>