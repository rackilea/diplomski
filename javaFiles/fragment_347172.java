public void characters(char ch[], int start, int length)
        throws SAXException {

    System.out.println("characters " + new String(ch, start, length));
    if (bfname) {
        System.out.println("Type : " + new String(ch, start, length));
        bfname = false;
        vtype = new String(ch, start, length);
        xm.textArea_3.append(vtype + "\n");
    }

    if (nameAttribute != null && !nameAttribute.equals("")) {
        System.out.println("Name : " + nameAttribute);
        xm.textArea.append(nameAttribute + "\n");
    }

    if (blname) {

        vvalue = new String(ch, start, length);
        System.out.println("Value:" + Double.valueOf(vvalue));
        // VALUE HERE IS ONLY DISPLAYED ONCE IN JFRAME
        xm.textArea_1.append(new Double(vvalue).toString() + "\n");
        blname = false;
    }
}