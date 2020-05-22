https://www.w3schools.com/php/php_mysql_connect.asp

<?php
$servername = "example.ddns.net";
$username = "username";
$password = "password";

// Create connection
$conn = new mysqli($servername, $username, $password);

// Check connection
if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
} 
echo "Connected successfully";
?>