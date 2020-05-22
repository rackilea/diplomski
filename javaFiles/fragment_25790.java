function md5_hash($password)
{
    $hashArray = array();
    $hash = md5($password);

    for ($x = 0; $x < strlen($hash); $x += 2)
        $hashArray[$x] = (($dec = hexdec(substr($hash, $x, 2))) > 127 ? $dec - 256 : $dec);

    return implode("", $hashArray);
}