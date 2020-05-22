$upload_url = 'http://192.168.1.77:8081/ImageProcessing/api/file/upload';
$params = array(
 'photo'=>file_get_contents('php://input')
);  

$ch = curl_init();
curl_setopt($ch, CURLOPT_VERBOSE, 1);
curl_setopt($ch, CURLOPT_URL, $upload_url);
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS, $params);
$response = curl_exec($ch);

echo $response;
curl_close($ch);