function encode5t($value1)
{
    for($i=0;$i<3;$i++)
    {
        $value1=base64_encode(strrev($value1));
    }

    return $value1;
}