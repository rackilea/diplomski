try {
        httpURL="http://google.co.in/";

        if ((WLANInfo.getWLANState() == WLANInfo.WLAN_STATE_CONNECTED)
                && RadioInfo
                        .areWAFsSupported(RadioInfo.WAF_WLAN)) {
            httpURL += ";interface=wifi";
        }else  if (TransportInfo.isTransportTypeAvailable(TransportInfo.TRANSPORT_BIS_B) && TransportInfo.hasSufficientCoverage(TransportInfo.TRANSPORT_BIS_B)) {
            System.out.println("BIS CONNECTION-------------------");
            // Holder.connectionInterface=";deviceside=false;ConnectionType=mds-public";
            httpURL += ";deviceside=false;ConnectionType=mds-public";
        } 
        //Dialog.alert(httpURL);
        HttpConnection httpConn;
        httpConn = (HttpConnection) Connector.open(httpURL);
        httpConn.setRequestMethod(HttpConnection.POST);
        DataOutputStream _outStream = new DataOutputStream(httpConn.openDataOutputStream());
        byte[] request_body = httpURL.getBytes();
        for (int i = 0; i < request_body.length; i++) {
            _outStream.writeByte(request_body[i]);
        }
        DataInputStream _inputStream = new DataInputStream(
        httpConn.openInputStream());
        StringBuffer _responseMessage = new StringBuffer();
        int ch;
        while ((ch = _inputStream.read()) != -1) {
            _responseMessage.append((char) ch);
        }
        String res = (_responseMessage.toString());
        responce = res.trim();

        //Dialog.alert(responce);

        httpConn.close();


    }catch (Exception e) {
        Dialog.alert("Error -"+e.toString());
    }