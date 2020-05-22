function getTopic($conn){
    $response = array("error" => 0);
    $qry = "SELECT original_title, content, time FROM topic WHERE vis = 1";
    $result = $conn->prepare($qry);
    $result->execute();
    if($result->rowCount() > 0){
        $output = $result->fetchall();
        foreach ($output as $o){
           $response['text'] = $o['original_title'];
           $response['test'] = $o['content'];
        }
        return json_encode($response);
    }
}