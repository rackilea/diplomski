$uploads_dir = '/Library/WebServer/Documents/Upload/upload/'.$_FILES['userfile']['name'];
if(is_uploaded_file($_FILES['userfile']['tmp_name'])) {
    echo $_POST["contentString"]."\n";
    echo  "File path = ".$uploads_dir;
    move_uploaded_file ($_FILES['userfile'] ['tmp_name'], $uploads_dir);
} else {
    echo "\n Upload Error";
    echo "filename '". $_FILES['userfile']['tmp_name'] . "'.";
    print_r($_FILES);