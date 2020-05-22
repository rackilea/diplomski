// you create a BufferedReader (no problems per se)
BufferedReader fileReader = new BufferedReader(new FileReader("C:/Users/Ilango/ellyworkspace/JacksonStreamingFindData/src/jsonFormattedModified.json"));

 // this consumes the fileReader stream
rootNode = jsonMapper.readTree(fileReader);

findByPath(rootNode);

// the next line is where the problem is happening
// fileReader has already been consumed, so the call to createParser() must fail
JsonParser jsonParser = jsonFactory.createParser(fileReader); // java.io.IOException: Stream closed