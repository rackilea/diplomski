$data = array();

if(isset($_POST['id'], $_POST['Project_Id']){
    $id=$_POST['id'];
    $project_id=$_POST['Project_Id'];

    $uname='root';
    $pwd='';
    $con =  new PDO("mysql:host=192.168.0.111;dbname=wktask", $uname, $pwd);
    $con->setAttribute( PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION );
    $stmt = $con->prepare('INSERT INTO task (`ID`, `Project_Id`) values(:id, :project_id)'))
    $success = $stmt->execute(array(':id'=>$id, ':project_id'=>$project_id));

    if($success){
       $data['code'] = 1;
       $data['msg'] = 'INSERT successful';
    }else{
       $data['code'] = 0;
       $data['msg'] = 'INSERT Failed';
    }


}else{
    $data['code'] = 0;
    $data['msg'] = 'values are not set';
}

echo(json_encode($data));