<?php
if(isset($_FILES)) {
    if(move_uploaded_file($_FILES["uploadedfile"]["tmp_name"],  "./data/".$_FILES["uploadedfile"]["name"]."_".time())) {

            echo " file recieved successfully"
            exit;
    }
}
echo "Error";

?>