SoapObject request = new SoapObject(ConstantValues.WSDL_TARGET_NAMESPACE, ConstantValues.METHOD_NAME1);
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = true;
        PropertyInfo pi = new PropertyInfo();
        pi.setName("strSQL");
        pi.setValue(ConstantValues.STUDENT_DETAILS);
        //pi.setType(ArrayList.class);
        request.addProperty(pi);
        envelope.setOutputSoapObject(request);

        HttpTransportSE httpTransportSE = new HttpTransportSE(ConstantValues.SOAP_ADDRESS);
        SoapObject response = null;
        httpTransportSE.debug=true; 
        httpTransportSE.setXmlVersionTag("<?xml version=\"1.0\" encoding=\"utf-8\"?>");

        httpTransportSE.call(ConstantValues.SOAP_ACTION1, envelope);
        response = (SoapObject)envelope.bodyIn;
        int totalCount = response.getPropertyCount();

        String resultString=httpTransportSE.responseDump;
        Log.d("XML data ",resultString);

        Document doc = XMLfunctions.XMLfromString(resultString);

        //int numResults = XMLfunctions.numResults(doc);

        System.out.println(totalCount);
        if(totalCount > 0){
            NodeList nodes = doc.getElementsByTagName("Table1");
            for (int i = 0; i < nodes.getLength(); i++) {
                studentData = new StudentDetailsData();
                Element e = (Element)nodes.item(i);

                studentData.setStudentId(Integer.parseInt(XMLfunctions.getValue(e, "StudentID")));
                studentData.setRegisterNo(XMLfunctions.getValue(e, "RegisterNumber"));
                studentData.setStudentName(XMLfunctions.getValue(e, "StudentName"));
                studentData.setGender(XMLfunctions.getValue(e, "Gender"));
                studentData.setCourseId(Integer.parseInt(XMLfunctions.getValue(e, "CourseID")));
                studentData.setBranchId(Integer.parseInt(XMLfunctions.getValue(e, "BranchID")));
                studentData.setBatchId(Integer.parseInt(XMLfunctions.getValue(e, "BatchID")));
                studentData.setRollNo(XMLfunctions.getValue(e, "RollNumber"));
                studentData.setSection(XMLfunctions.getValue(e, "Section"));

                result.add(studentData);

            }
        }