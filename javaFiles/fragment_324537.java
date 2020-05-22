<?php
function get_html($url)
{
$curl = curl_init();
curl_setopt ($curl, CURLOPT_URL, 'http://127.0.0.1:10000/?url=' . $url . '&delay=3000&view=as-is');
curl_setopt($curl, CURLOPT_RETURNTRANSFER, 1);
$html = curl_exec ($curl);
return $html;
}
?>