ZenDesk zd = new ZenDesk.Builder("https://{{your domain}}.zendesk.com")
        .setUsername("...")
        .setToken("...") // or .setPassword("...")
        .build();

byte[] contents = new byte[file.length()];
FileInputStream fis = new FileInputStream(fis);
fis.read(contents);
fis.close();

Attachment.Upload upload = zd.createUpload(file.getName(), "application/binary", contents);

zd.close();