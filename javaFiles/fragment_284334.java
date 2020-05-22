<?php
    //Initiate Connection
    $conn = new PDO('mysql:host='.$db_host.';dbname='.$db_name, $db_user, $db_password);

    $username = $_POST["username"];
    $password = $_POST["password"];
    $hashedPassword = password_hash($password, PASSWORD_BCRYPT);
    $mobilenumber = $_POST["mobilenumber"];
    $email = $_POST["email"];

    $stmt = $conn->prepare("INSERT INTO user (username, hashedPassword, mobilenumber, email) VALUES (:username, :password, :mobile, :email)");

    if ($stmt->execute(array(':username' => $username, ':password' => $hashedPassword, ':mobile' => $mobilenumber, ':email' => $email))) {
        $response["success"] = true; 
    } else {
        $response["success"] = false; 
    }

    header('Content-Type: application/json');
    echo json_encode($response);
?>