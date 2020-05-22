<?php

$ch = curl_init();

curl_setopt($ch, CURLOPT_URL,"http://www.site.com/test.php");
curl_setopt($ch, CURLOPT_POST, 1);
curl_setopt($ch, CURLOPT_POSTFIELDS,
            "var1=value1&var2=value2&var3=value3");

// Get server response ...
curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);

$result = curl_exec ($ch);

curl_close ($ch);

// further processing ....
if ($result == "OK") { ... } else { ... }

?>