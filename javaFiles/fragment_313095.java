//Upload the file
$file_path = "ZipFiles/";     
$file_path = $file_path . basename( $_FILES['uploaded_file']['name']);
if(move_uploaded_file($_FILES['uploaded_file']['tmp_name'], $file_path)) {
    echo "success";
    $zip = new ZipArchive();
    $zip->open($file_path);
    $zip->extractTo("UnzipFiles/");
    $zip->close(); 
} else{
    echo "fail";
}