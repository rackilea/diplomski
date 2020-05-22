<?php 
    if(isset($_GET['fname']) and $_GET['fname']){
        // do something with filename to decide from where to donwload
        if($_GET['fname']=="DWSM_Domain.png") $targetfile ="ftp://anonymous:test@mailinator.com@ftp.swfwmd.state.fl.us/pub/CFWI_HAT/DWSM_Domain.png";   
        if($_GET['fname']=="file1") $targetfile ="ftp://someuser:somepassword@ftp.swfwmd.state.fl.us/somepath/file1";
        if($_GET['fname']=="file2") $targetfile ="ftp://someuser:somepassword@ftp.swfwmd.state.fl.us/somepath/file2";

        echo $targetfile;
    }
?>