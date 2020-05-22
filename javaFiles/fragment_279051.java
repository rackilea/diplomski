Element[] header = new Element[1];
        header[0] = new Element().createElement(NAMESPACE, "CompanyHeader");

        Element accountInfo = new Element().createElement(NAMESPACE, "AccountInfo");
        header[0].addChild(Node.ELEMENT, accountInfo);

        Element apiKey = new Element().createElement(NAMESPACE, "PartnerID");
        apiKey.addChild(Node.TEXT, "String");
        accountInfo.addChild(Node.ELEMENT, apiKey);

        SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME);

        PropertyInfo keyword =new PropertyInfo();
        keyword.name = "keyword";
        keyword.setValue("string");
        request.addProperty(keyword);

        PropertyInfo records =new PropertyInfo();
        records.name = "records";
        records.setValue(int);
        request.addProperty(records);

        PropertyInfo startingRecord =new PropertyInfo();
        startingRecord.name = "startingRecord";
        startingRecord.setValue(int);
        request.addProperty(startingRecord);

        PropertyInfo searchOptions =new PropertyInfo();
        searchOptions.name = "searchOptions";
        searchOptions.setValue(string);
        request.addProperty(searchOptions);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope
                .VER11);
        envelope.dotNet = true;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        envelope.headerOut = header;
        envelope.bodyOut = request;

        HttpTransportSE ht = getHttpTransportSE();

        try {
            ht.call(SOAP_ACTION, envelope);
        } catch (HttpResponseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } finally {
            try {
                if (envelope.getResponse() != null) {
                    SoapObject result = (SoapObject)envelope.getResponse();
                    Log.e("Results = ", String.valueOf(results));
                }
            } catch (SoapFault e) {
                e.printStackTrace();
            }
        }