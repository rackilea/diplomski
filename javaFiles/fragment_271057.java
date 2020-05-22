<?php
$xml     = '<request>Testing</request>';
$server  = '...'; // URL to server.php
$options = array 
(
    CURLOPT_URL            => $server,
    CURLOPT_POST           => true,
    CURLOPT_POSTFIELDS     => $xml,
    CURLOPT_RETURNTRANSFER => true
);


$curl = curl_init();
curl_setopt_array($curl, $options);
$response = curl_exec($curl);
curl_close($curl);

echo '<pre>', htmlspecialchars($response), '</pre>';

?>