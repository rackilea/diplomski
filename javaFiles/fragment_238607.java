<?php 
if(isset($_GET['fname']) and $_GET['fname']){
    // do something with filename to decide from where to donwload
    if($_GET['fname']=="DWSM_Domain.png") header("Location: ftp://anonymous:test@mailinator.com@ftp.swfwmd.state.fl.us/pub/CFWI_HAT/DWSM_Domain.png");  
    if($_GET['fname']=="file1") header("Location: ftp://someuser:somepassword@ftp.swfwmd.state.fl.us/somepath/file1");
    if($_GET['fname']=="file2") header("Location: ftp://someuser:somepassword@ftp.swfwmd.state.fl.us/somepath/file2");
    exit;
} 
?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Untitled Document</title>
</head>
<body>
    <p><a href="/test.php?fname=DWSM_Domain.png">DWSM_Domain.png</a></p>
    <p><a href="/test.php?fname=file1">file1</a></p>
    <p><a href="/test.php?fname=file2">file2</a></p>
</body>