SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
    envelope.implicitTypes = true;

    SoapObject root = new SoapObject(NAMESPACE, "method name");
    PropertyInfo mode = new PropertyInfo();
    mode.setNamespace(NAMESPACE);
    mode.setName("mode");
    mode.setValue("value");
    mode.setType(String.class);
    root.addProperty (mode);
   //root.addProperty("mode", "value");
    envelope.setOutputSoapObject(root/*request*/);

    Log.d(TAG, envelope.toString());

    HttpTransportSE transport = new HttpTransportSE(url);
    transport.debug = true;
    try {
        transport.call(NAMESPACE.concat("/").concat("Method of server"), envelope);
        Log.d(Qube.TAG, transport.requestDump);
        Log.d(Qube.TAG, transport.responseDump);