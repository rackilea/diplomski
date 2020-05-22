public void characters(char ch[], int start, int length) throws SAXException {
    ... Code Here ...       
    if (bfname) {
        employeeName = new String(ch, start, length);
        bfname = false;
    }
    ... Code Here ...
}