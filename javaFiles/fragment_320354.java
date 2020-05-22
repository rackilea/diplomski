class mySoapClient extends \SoapClient
{
    public function __doRequest($request, $location, $action, $version, $one_way = 0)
    {
        $request = str_replace(
            array('SOAP-ENV', 'other-text'),
            array('s', 'new-other-text'),
            $request
        );

        return parent::__doRequest($request, $location, $action, $version, $one_way);
    }
}