String path = Swagger2MarkupConverterTest.class.getResource(
        "/json/swagger.json").getFile();

path = URLDecoder.decode(path, "UTF-8");

File file = new File(path);