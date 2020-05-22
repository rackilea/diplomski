Log.d("QR Code",scanData);
    XmlPullParserFactory pullParserFactory;

    try {
        // init the parserfactory
        pullParserFactory = XmlPullParserFactory.newInstance();
        // get the parser
        XmlPullParser parser = pullParserFactory.newPullParser();

        parser.setFeature(XmlPullParser.FEATURE_PROCESS_NAMESPACES, false);
        parser.setInput(new StringReader(scanData));

        // parse the XML
        int eventType = parser.getEventType();
        while (eventType != XmlPullParser.END_DOCUMENT) {
            if(eventType == XmlPullParser.START_DOCUMENT) {
                Log.d("QR Code","Start document");
            } else if(eventType == XmlPullParser.START_TAG && DataAttributes.DATA_TAG.equals(parser.getName())) {
                // extract data from tag
                //uid
                uid = parser.getAttributeValue(null,DataAttributes.UID_ATTR);
                //name
                name = parser.getAttributeValue(null,DataAttributes.NAME_ATTR);
                //gender
                gender = parser.getAttributeValue(null,DataAttributes.GENDER_ATTR);
                // guardian name
                gname = parser.getAttributeValue(null,DataAttributes.GNAME_ATTR);
                // house number
                house = parser.getAttributeValue(null,DataAttributes.HOUSE_ATTR);
                // Street name
                street = parser.getAttributeValue(null,DataAttributes.STREET_ATTR);
                // landmark
                lm = parser.getAttributeValue(null,DataAttributes.LM_ATTR);
                // locality
                loc = parser.getAttributeValue(null,DataAttributes.LOC_ATTR);
                // village town city
                vtc = parser.getAttributeValue(null,DataAttributes.VTC_ATTR);
                // Post Office
                po = parser.getAttributeValue(null,DataAttributes.PO_ATTR);
                // district
                dist = parser.getAttributeValue(null,DataAttributes.DIST_ATTR);
                // sub-division
                subdist = parser.getAttributeValue(null,DataAttributes.SUBDIST_ATTR);
                // state
                state = parser.getAttributeValue(null,DataAttributes.STATE_ATTR);
                // Post Code
                pc = parser.getAttributeValue(null,DataAttributes.PC_ATTR);
                // Date of Birth
                dob = parser.getAttributeValue(null,DataAttributes.DOB_ATTR);


            } else if(eventType == XmlPullParser.END_TAG) {
                Log.d("QR Code","End tag "+parser.getName());

            } else if(eventType == XmlPullParser.TEXT) {
                Log.d("QR Code","Text "+parser.getText());

            }
            // update eventType
            eventType = parser.next();
        }

        // display the data on screen
        String na = "N/A";

            if (uid == null){
                        tv_uid.setText(na);
            }else {
                        tv_uid.setText(uid);
            }

            if (name == null){
                        tv_name.setText(na);
            }else {
                        tv_name.setText(name);
            }

            if (gender == null){
                        tv_gender.setText(na);
            }else {
                        tv_gender.setText(gender);
            }

            if (gname == null){
                tv_gName.setText(na);
            }else {
                tv_gName.setText(gname);
            }

            if (house == null){
                tv_house.setText(na);
            }else {
                tv_house.setText(house);
            }

            if (street == null){
                tv_street.setText(na);
            }else {
                tv_street.setText(street);
            }

            if (lm == null){
                tv_lm.setText(na);
            }else {
                tv_lm.setText(lm);
            }

            if (loc == null){
                tv_loc.setText(na);
            }else {
                tv_loc.setText(loc);
            }

            if (vtc == null){
                tv_vtc.setText(na);
            }else {
                tv_vtc.setText(vtc);
            }

            if (po == null){
                tv_po.setText(na);
            }else {
                tv_po.setText(po);
            }

            if (dist == null){
                tv_dist.setText(na);
            }else {
                tv_dist.setText(dist);
            }

            if (subdist == null){
                tv_subdist.setText(na);
            }else {
                tv_subdist.setText(subdist);
            }

            if (state == null){
                tv_state.setText(na);
            }else {
                tv_state.setText(state);
            }

            if (pc == null){
                tv_pc.setText(na);
            }else {
                tv_pc.setText(pc);
            }

            if (dob == null){
                tv_dob.setText(na);
            }else {
                tv_dob.setText(dob);
            }
    } catch (XmlPullParserException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}