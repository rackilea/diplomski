<?php
    $json = file_get_contents('php://input');
    $obj = json_decode($json);
    print_r($obj);
    print_r("this is a test response");
?>