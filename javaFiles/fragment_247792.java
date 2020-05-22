<?php
$codservic=$_POST['Value1'];    
$image = $_POST['Image'];
header("Content-type: image/jpg");
$img = base64_decode($image);
$con = mysqli_connect("your connection string") or die('Unable To connect');
$sql = "insert into yourtable (yourcamp1,image) values(?,?)";
$stmt = mysqli_prepare($con,$sql);
mysqli_stmt_bind_param($stmt,"is",$codservic,$img);
$sucesso=mysqli_stmt_execute($stmt);
$estado = array();
if($sucesso){
    $estado[status] = "sucess";
    echo json_encode($estado);
} else {
    $estado[status] = "error";
    echo json_encode($estado);
}
?>