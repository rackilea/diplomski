<?php   
$response = array();
if (isset($_POST['username'], $_POST['password'])) {  
    require("config.inc.php");
    try {
        $query = " 
            SELECT 
                id, 
                username, 
                password
            FROM users 
            WHERE 
                username = :username
            AND password = :password
        ";

        $stmt   = $db->prepare($query);
        $result = $stmt->execute(array(':username' => $_POST['username'],
                                       ':password' => $_POST['password']
                         ));
        if($stmt->rowCount == 1){
            $response["success"] = true;
            $response["message"] = "user found";        
        }else{
            $response["success"] = false;
            $response["message"] = "user not found";
        }
    }
    catch (PDOException $ex) {
        $response["success"] = false;
        $response["message"] = "Database Error1. Please Try Again!";
    }

} else {          
    $response["success"] = false;         
    $response["message"] = "User Name and password not set"; 
}
echo json_encode($response);