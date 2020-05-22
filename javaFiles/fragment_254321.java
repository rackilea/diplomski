Path inputPath = Paths.get("inputXML.txt");
String input = new String(Files.readAllBytes(inputPath,
                   StandardCharsets.UTF_8));
input = input.replaceFirst("<quasiroot", "<root>$0")
    + "</root>";

Source text = new StreamSource(new StringReader(input));