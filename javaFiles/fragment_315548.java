//String resultMessage = ...
            Pdu pdu = new PduParser().parsePdu(resultMessage);
            byte[] bytes = pdu.getUserDataAsBytes();
            String decodedMessage;
            int dataCodingScheme = pdu.getDataCodingScheme();
            if (dataCodingScheme == PduUtils.DCS_ENCODING_7BIT) {
                decodedMessage = PduUtils.decode7bitEncoding(null, bytes);
            } else if (dataCodingScheme == PduUtils.DCS_ENCODING_8BIT) {
                decodedMessage = PduUtils.decode8bitEncoding(null, bytes);
            } else if (dataCodingScheme == PduUtils.DCS_ENCODING_UCS2) {
                decodedMessage = PduUtils.decodeUcs2Encoding(null, bytes);
            } else {
                log.error("Unknown DataCodingScheme!");
                ...
            }