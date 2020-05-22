String encoding = "UTF-16LE";
    byte[] byteArray = "chess ¾".getBytes(encoding);
    for (int i = 0; i < byteArray.length; i++) {
        // your conversion
        System.out.print(" " + (byteArray[i] < 0 ? (-byteArray[i] + 128) : byteArray[i]));
       // a more appropriate one
        System.out.print("(" + (byteArray[i] & 0xFF) + ") ");
    }
    System.out.println("");
    System.out.println(new String(byteArray, encoding));