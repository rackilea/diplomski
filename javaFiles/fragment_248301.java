Base64.Encoder enc = Base64.getEncoder();
    Base64.Encoder encURL = Base64.getUrlEncoder();

    byte[] bytes = enc.encode("subjects?_d".getBytes());
    byte[] bytesURL = encURL.encode("subjects?_d".getBytes());

    System.out.println(new String(bytes)); // c3ViamVjdHM/X2Q=      notice the "/"
    System.out.println(new String(bytesURL)); // c3ViamVjdHM_X2Q=   notice the "_"

    Base64.Decoder dec = Base64.getDecoder();
    Base64.Decoder decURL = Base64.getUrlDecoder();

    byte[] decodedURL = decURL.decode(bytesURL);
    byte[] decoded = dec.decode(bytes);

    System.out.println(new String(decodedURL));
    System.out.println(new String(decoded));