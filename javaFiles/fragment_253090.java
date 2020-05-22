$id = $_GET['id'];
$path = 'Profile_Images/'.$id.'.jpg';

$type = 'image/jpeg';
header('Content-Type:'.$type);
header('Content-Length: ' . filesize($path));
readfile($path);