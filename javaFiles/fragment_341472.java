function getTopic($conn){
    $response = array('error'=>0);
    $qry = "SELECT original_title, content, time FROM topic WHERE vis = 1";
    $result = $conn->prepare($qry);
    $result->execute();
    if($result->rowCount() > 0){
        $output = $result->fetchall();
        foreach ($output as $o){
           $response[] = array('text'=>$o['original_title'],'test'=>$o['content']);
        }
        return json_encode($response);
    }
}