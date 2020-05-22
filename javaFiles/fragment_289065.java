$users = array(...);
foreach($users as $user) {
    $mysqli->prepare("INSERT INTO `users` (`email`, `imei`) VALUES (?,?)")l
    $result->bind_param("ss", $user['email'], $user['imei']);
    $result->execute();
    $result->close();
}