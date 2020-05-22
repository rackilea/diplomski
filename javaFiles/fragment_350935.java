public String getValue(String key) {
        int start = this.xmldoc.indexOf("<key>"+ key + "</key>");

        if(start == -1)
            return "";


        String xmldoc2 = this.xmldoc.substring(start);

        start = xmldoc2.indexOf("</key>");
        xmldoc2 = xmldoc2.substring(start);

        xmldoc2 = xmldoc2.substring(6);

        start = xmldoc2.indexOf(">");
        xmldoc2 = xmldoc2.substring(start + 1);

        int end = xmldoc2.indexOf("</");

        xmldoc2 = xmldoc2.substring(0, end);
        return xmldoc2;

    }

public boolean checkFieldPresence(String key)
{
        int start = this.xmldoc.indexOf(key + "</key>");

        if(start == -1)
            return false;
        else
            return true;
}