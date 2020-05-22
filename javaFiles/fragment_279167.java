if(isset($_GET['name']) && isset($_GET['text']))  {
    $filename = preg_replace('#[^A-Za-z0-9_-]#', '', $_GET['name']);
    $file = $_SERVER['DOCUMENT_ROOT']."/textfiles/$filename.txt";
    $f = fopen($file, 'w');
    fwrite($f, $_GET['text']);
    fclose($f);
    echo 'Success.';
}  else  {
    echo 'Error.';
}