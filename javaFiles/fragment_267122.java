<?php
    print_r($_POST);
    $json_string = $_POST['message']; 
    $json = json_decode($json_string);
    print_r($json);
?>