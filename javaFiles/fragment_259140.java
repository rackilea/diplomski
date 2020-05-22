Map<String, List<String>> reqHeaders 
            = CastUtils.cast((Map<?, ?>)message.get(Message.PROTOCOL_HEADERS));
        if (reqHeaders == null) {
            reqHeaders = new TreeMap<String, List<String>>(String.CASE_INSENSITIVE_ORDER);
        }

        if (reqHeaders.size() == 0) {
            message.put(Message.PROTOCOL_HEADERS, reqHeaders);
        }

        if (!reqHeaders.containsKey(SoapBindingConstants.SOAP_ACTION)) {            
            reqHeaders.put(SoapBindingConstants.SOAP_ACTION, Collections.singletonList(action));
        }