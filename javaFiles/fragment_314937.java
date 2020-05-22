String encoded = Base64.encodeFromFile("data/inputImage.png");

            //Convert String data to binary image file
            Base64.decodeToFile(encoded, "data/outputImage.png");

            //Convert binary image file to byte array to base64 encoded string
            FileInputStream mFileInputStream = new FileInputStream("data/inputImage.png");
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] b = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = mFileInputStream.read(b)) != -1) {
               bos.write(b, 0, bytesRead);
            }
            byte[] ba = bos.toByteArray();
            encoded = Base64.encodeBytes(ba);

            //Convert String data to binary image file
            Base64.decodeToFile(encoded, "data/outputImage.png");

            //Convert binary image file to base64 encoded String data file
            Base64.encodeFileToFile("data/inputImage.png","data/encodedImage.txt");

            //Convert base64 encoded String data file to binary image file
            Base64.decodeFileToFile("data/encodedImage.txt","data/outputImage.png");