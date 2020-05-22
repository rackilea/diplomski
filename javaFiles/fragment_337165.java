class XmlToDb {
    private $data = array();
    private $currentTagname;

    private function parseXML($xmlContent) {
        $xmlParser = xml_parser_create();
        xml_set_character_data_handler($xmlParser, array($this, 'contentElement'));
        xml_set_element_handler( $xmlParser, array($this, "startElement"), array($this, "endElement"));
        if(!xml_parse($xmlParser, $xmlContent)){
            die("Error on line " . xml_get_current_line_number($xmlParser));
        }
        xml_parser_free($xmlParser);
    }
    public function save($xml) {
        $this->parseXML($xml);

        $sql = "INSERT INTO [table] VALUES ('" . $this->data['MESSAGEID'] . "', '" . $this->data['INSTCODE'] . "')";
        echo $sql;
    }

    private function contentElement($parser, $data) {
        $data = trim($data);
        if (!empty($data)) {
            $this->data[$this->currentTagname] = $data;
        }
    }

    private function startElement( $parser, $tag, $attributeList) {
        if ($tag == 'MESSAGEID') {
            // @todo add specific validation to this element. e.g. make sure its valid number
        } else if ($tag == 'INSTCODE') {
        } else {
        }
        $this->currentTagname = $tag;
    }
    private function endElement( $parser, $tag ) {
        return '';
    }
}

$xmlContent= '
<urn:outgoing  xmlns:env="http://www.w3.org/2003/05/soap-envelope">
  <pob xsi:type="out:OutgoingTransactionRqstInfo"
  xmlns:out="http://www.shantanuoak.com/OutgoingService">
    <messageID xsi:type="xsd:int">9999</messageID>
    <instCode xsi:type="soapenc:string" 
    xmlns:soapenc="http://schemas.xmlsoap.org/soap/encoding/">?</instCode>
  </pob>
</urn:outgoing>
';
$xmlToDb = new XmlToDb();
$xmlToDb->save($xmlContent);