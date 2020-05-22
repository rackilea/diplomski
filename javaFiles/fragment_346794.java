try {
        header = AESCryptt.encrypt("the key is fixed is this case",header);
    } catch (Exception ex) {
        ex.printStackTrace();
        System.out.println("eee , exception during encrypt log in data . . . .");
    }