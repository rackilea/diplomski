$secretKeyArray = array(18, -15, -48, 73, 54, -115, 34, -87);

$secretString = '';
foreach($secretKeyArray as $k => $v) {
   $secretString.= chr($v & 0xFF); // trim to 8 bits (for the negative values)
}