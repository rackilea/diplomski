// NOTE: workaround. too bit bytes doesn't writted correctly.
        byte[] bytes = plainString.getBytes("UTF-8");

        int oneBulkSize = 1024;// temp value for proof of concept. might be bigger one.
        int numOfBulk = (bytes.length / oneBulkSize);

        for (int i = 0; i < numOfBulk; i++) {
            cipherOutputStream.write(bytes, oneBulkSize * i, oneBulkSize);
        }

        if ((bytes.length % oneBulkSize) != 0) {
            cipherOutputStream.write(bytes, oneBulkSize * numOfBulk, bytes.length % oneBulkSize);
        }
        cipherOutputStream.close();