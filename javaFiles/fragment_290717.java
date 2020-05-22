// a field in the MyHandler class:
    boolean mIsSegment = false;
    // ...
    @Override
    public void characters(char[] ch, int start, int length)
            throws SAXException {
        // TODO Auto-generated method stub
        super.characters(ch, start, length);
        if (is_sno) {
            al_sno.add(new String(ch, start, length));
        } else if (is_sname) {
            if (!mIsSegment) {
                al_sname.add(new String(ch, start, length));
            } else {
                al_sname.set(al_sname.size() - 1,
                        al_sname.get(al_sname.size() - 1)
                                + new String(ch, start, length));
            }
            mIsSegment = true;
        }

    }

    @Override
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        // TODO Auto-generated method stub
        super.endElement(uri, localName, name);

        if (localName.equals("ID")) {
            is_sno = false;
        } else if (localName.equals("Name")) {
            is_sname = false;
            mIsSegment = false;
        }

    }
    // ...