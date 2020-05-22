<?php

$con = mysqli_connect("127.0.0.1","root","", "yield");


    $name = $_POST["name"];
    $age = $_POST["age"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $statement = mysqli_prepare($con, "INSERT INTO users (name, username, age, password) VALUES (?, ?, ?, ?)") or die (mysqli_error($con));
    mysqli_stmt_bind_param($statement, "siss", $name, $username, $age, $password);
    mysqli_stmt_execute($statement);

    $response = array();
    $response["success"] = true;  

    echo json_encode($response);
?>