<?php 

$target_path = "../output/"; 

$target_path = $target_path . basename( $_FILES['MyTxtFile']['name']); 


if(move_uploaded_file($_FILES['MyTxtFile']['tmp_name'], $target_path)) { 
echo "The file ". basename( $_FILES['MyTxtFile']['name'])." has been uploaded"; 
} 
else{ 
echo "There was an error uploading the file, please try again!"; 
}


?>