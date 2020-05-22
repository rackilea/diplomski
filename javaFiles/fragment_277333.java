class MySoapClient extends SoapClient {
    function __doRequest( $request, $location, $action, $version, $one_way = NULL ) {
        $request = str_replace("SOAP-ENV", "soapenv", $request);
        $request = str_replace("xsi", "com", $request);
        $request = str_replace("ns1", "com", $request);
        var_dump($request);
        return parent::__doRequest( $request, $location, $action, $version, $one_way );
    }
}