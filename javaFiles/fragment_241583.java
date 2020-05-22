$urladdress = "www.javaapicart.com/getCart.jsp"
$data = "json=".json_encode($dataCart)

$ch = curl_init(); curl_setopt($ch, CURLOPT_URL, $urladdress); 
curl_setopt($ch, CURLOPT_POST, 1); 
curl_setopt($ch, CURLOPT_POSTFIELDS, $data); 
curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1); 
curl_setopt($ch, CURLOPT_HEADER, 0); 

curl_exec ($ch) or die(curl_error($ch)); 
curl_close ($ch);