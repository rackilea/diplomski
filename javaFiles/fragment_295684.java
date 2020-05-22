<?php 

$key='Your aws key';
 $pwd='Your AWS secret key';



// See docs   ://docs.amazonwebservices.com/AWSEC2/latest/APIReference/------->Actions---->Describe Regions 

//for making a request to the aws


 $params = array(   
 'Action' => 'DescribeAvailabilityZones',
 'AWSAccessKeyId' => $key, 
 'Timestamp' => gmdate('Y-m-d\TH:i:s\Z'),
 'Version' => '2008-05-05', 
 'ZoneName.0' => 'us-east-1a',
 'ZoneName.1' => 'us-east-1b',    
 'ZoneName.2' => 'us-east-1c', 
 'SignatureVersion' => 2,  
 'SignatureMethod' => 'HmacSHA256'
 );




 uksort($params, 'strnatcmp');
 $qstr = ''; 
 foreach ($params as $key => $val) {
 $qstr .= "&{$key}=".rawurlencode($val);
 }
 $qstr = substr($qstr, 1);

 // Signature Version 2 

 $str = "GET\n"  
 . "ec2.amazonaws.com\n"
 . "/\n"      
 . $qstr; 


 $params['Signature'] = base64_encode( hash_hmac('sha256', $str, $pwd, true) );  // Generating a base64-encoded RFC 

//2104-compliant HMAC-SHA256 



 $req = 'https://ec2.amazonaws.com/?' . http_build_query(     $params );  // encoded query string 

 echo '<a href="'.$req.'">XML</a><p>';//For Navigating or creating a request.



 ?>