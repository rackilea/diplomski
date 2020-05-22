InputStream is = urlClassLoader.getResourceAsStream(className + ".class");

        byte[] content = new byte[is.available()];
        is.read(content);

        System.out.println ("Original class version: " + ((classfileBuffer[6]&0xff)<<8 | (classfileBuffer[7]&0xff)));
        System.out.println ("Redefined class version: " + ((content[6]&0xff)<<8 | (content[7]&0xff)));