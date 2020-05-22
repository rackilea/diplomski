<?php 
    header('Access-Control-Allow-Origin: *');
    $path = $_POST['path'];
    $name = $_FILES['file']['name'];
    $info = pathinfo($name);
    $ext = $info['extension']; // get the extension of the file
    $target = $path.$name;
    move_uploaded_file( $_FILES['file']['tmp_name'], $target);
    http_response_code(200);
?>