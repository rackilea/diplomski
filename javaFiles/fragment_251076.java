public void convertByteArrayToString(Charset encoding) {

        byte[] byteArray = new byte[] {87, 79, 87, 46, 46, 46};

        String value = new String(byteArray, encoding);

        System.out.println(value);
    }