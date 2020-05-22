<?php
include 'dbh.inc.php';

$uid = mysqli_real_escape_string($conn, $_POST['uid']);
$pwd = mysqli_real_escape_string($conn, $_POST['pwd']);

$response = array();

$sql = "SELECT * FROM users WHERE user_uid='$uid' OR user_email='$uid';";
$result = mysqli_query($conn, $sql);
$resultCheck = mysqli_num_rows($result);
if ($resultCheck < 1) {
    echo 'error resultCheck < 1';
    exit();
} else {
    if ($row = mysqli_fetch_assoc($result)) {
        $row = mysqli_fetch_array($result);
        //De-hashing the password
        $hashedPwdCheck = password_verify($pwd, $row['user_pwd']);
        if ($hashedPwdCheck == false) {
         echo 'error hashedPwdCheck == false';
         exit();
        } elseif ($hashedPwdCheck == true) {

            $user = array();
            $user["user_id"] = $row[0];
            $user["user_first"] = $row[1];
            $user["user_last"] = $row[2];
            $user["user_email"] = $row[3];
            $user["user_uid"] = $row[4];
            $response["success"] = 1;
            $response["user"] = array();


            array_push($response["user"], $user);


            echo json_encode($user);
            exit();
        }
       echo 'final exit';
       exit();


    }
}