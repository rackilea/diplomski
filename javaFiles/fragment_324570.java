/**
 * 
 * @param contentxml
 * @param xmlAttributeName
 * @param xmlAttributeValue
 * @return xml with inserted node value
 */
private static String insertXmlAttributeValue(String xml, String xmlAttributeName, String xmlAttributeValue){
    if(StringUtils.isNotEmpty(xmlAttributeValue)){
        String xmlAttributeKey = xmlAttributeName + "=\"\"";
        xmlAttributeValue = xmlAttributeName + "=\""+ xmlAttributeValue+"\"" ;
        xml = xml.replace(xmlAttributeKey, xmlAttributeValue);
    }
    return xml;
}