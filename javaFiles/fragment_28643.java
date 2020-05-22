public void characters(char ch[], int start, int length) throws SAXException {
    ... Code Here ...
    if (bsalary) {
        String nodeValue=new String(ch, start, length);\
            if(nodeValue.compareTo("100000")==0)
            {
                //Use employeeName Here...
            }
        bsalary = false;
    }
    ... Code Here ...
}