class Signature
{
    private static $algorithm = OPENSSL_ALGO_SHA512;
    private static $signaturePrefix = '-----BEGIN SIGNATURE-----';
    private static $signaturePostfix = '-----END SIGNATURE-----';

    public static function createSignature($message, $privateKey)
    {
        $signature = null;

        openssl_sign($message, $signature, $privateKey, self::$algorithm);

        return self::$signaturePrefix . base64_encode($signature) . self::$signaturePostfix;
    }

    public static function verifySignature($message, $publicKey, $signature)
    {
        $signature = str_replace(self::$signaturePrefix, '', $signature);
        $signature = str_replace(self::$signaturePostfix, '', $signature);

        return openssl_verify($message, base64_decode($signature), $publicKey, self::$algorithm);
    }

    public static function signJSON($jsonToSign, $privateKey)
    {
        if(gettype($jsonToSign) != 'string')
            $jsonToSign = json_encode($jsonToSign);

        $signedJSON = json_decode('{}');
        $sigedJSON->signature = self::createSignature($message, $privateKey);
        $signedJSON->object = $jsonToSign;

        return $signedJSON;
    }

    public static function verifyJSONSignature($jsonObject, $publicKey)
    {
        if(gettype($jsonObject->object) == 'string')
            throw new Exception('Value $jsonObject->object must be a String, is a ' . gettype($jsonObject->object));

        return self::verifySignature($jsonObject->object, $publicKey, $jsonObject->signature);
    }
}