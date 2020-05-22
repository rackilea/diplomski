for (int y = 0; y < ClinicInfo.getLength(); y++) {
            Node info = ClinicInfo.item(y);
            if (info.hasChildNodes()) {
                Log.e(info.getNodeName(), info.getFirstChild().getNodeValue());
            }
        }