File imageFile = new File(filename);
        Path path = imageFile.toPath();
        byte[] data = Files.readAllBytes(path);

        String str = DatatypeConverter.printBase64Binary(data);
        //Store encoded data.
        //Retrieve encoded string from the database.
        byte [] data2 = DatatypeConverter.parseBase64Binary(str);

        InputStream inputStream = new ByteArrayInputStream(data2);
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        Metadata metadata = ImageMetadataReader.readMetadata(bis);