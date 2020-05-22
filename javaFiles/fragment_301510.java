if(isset($_POST))
    {
     $json = file_get_contents('php://input');
     $jsonObj = json_decode($json);
     echo $jsonObj;
    }