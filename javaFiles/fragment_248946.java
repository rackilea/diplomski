<?php
$json = array();
if(isset($_POST['id'], $_POST['twd'])){
    /*Importing our db connection script*/
    require_once('dbConnect.php');
    /* check connection */
    if (mysqli_connect_errno()) {
        printf("Connect failed: %s\n", mysqli_connect_error());
        exit();
    }
    $id = mysqli_real_escape_string($con, $_POST['id']);
    $twd = mysqli_real_escape_string($con, $_POST['twd']);

    $sql ="SELECT MAX(id) as MaxId FROM work_details WHERE twd = '$twd'";

    if ($result = mysqli_query($con, $sql)) {
        /* fetch associative array */
        if ($row = mysqli_fetch_row($result)) {
            if($row[0] === $id){
                $sql ="DELETE FROM work_details WHERE id='$id';";
                if ($result = mysqli_query($con, $sql)) {
                    echo 'success';
                    $json['success'] = true;
                    $json['message'] = 'delete is successful';
                }else{
                    $json['success'] = false;
                    $json['message'] = 'list cannot be deleted';
                }
            }else{
                $json['success'] = false;
                $json['message'] = '($row[0] !== $id)';         
            }
        } else{
            $json['success'] = false;
            $json['message'] = 'select is unsuccessful';            
        }
    /* close connection */
    mysqli_close($con);
    }
}
?>