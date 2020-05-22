public void endElement(String s, String s1, String element) throws SAXException {

if (OrgDataPartitonObj != null && "fs:FinancialStatementLineItemDataItem".equals(OrgDataPartitonObj.getType())) {

  FinancialStatementLineItemParser.getEndElementFinancialStatementLineItemParser(financialStatementLineItemObj, element, tmpValue);
        }
tmpValue="";
}