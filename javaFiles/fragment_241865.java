$response["success"] = true;
$record_size = 0;

while(mysqli_stmt_fetch($statement)){
    $response["success"] = true;        
    $response["username"] = $username;
    $response["password"] = $password;
    $response["email"] = $email;
    $response["age"] = $age;
    $response["realname"] = $realname;
    $response["streetname"] = $streetname;
    $response["postcode"] = $postcode;
    $response["city"] = $city;
    $response["state"] = $state;
    $response["isPremium"] = $isPremium;
    $response["isLoggedIn"] = $isLoggedIn;
    $record_size++;
}

$response["record_size"]  = $record_size;

echo json_encode($response);