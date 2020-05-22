<?php
$con=mysqli_connect("logindetailsgohere");

if (mysqli_connect_errno($con))
{
echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

if (isset($_POST['un']) && isset($_POST['pw']) && isset($_POST['uid'])){
$uname = mysql_real_escape_string($_POST['un']);
$pass = mysql_real_escape_string($_POST['pw']);
$uid = intval($_POST['uid']);
$sql = "INSERT IGNORE INTO Users (id, Username, Password) VALUES ('$uid', '$uname', '$pass')";
if(mysqli_query($con, $sql){
    echo "Values have been inserted";
}
}

mysqli_close($con);
?>