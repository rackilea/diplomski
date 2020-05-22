ObjectMapper map = new ObjectMapper(); //for later inner object data binding
JsonParser p = map.getFactory().createParser(new File("test.json"));
//start the tokenizing of object
p.nextToken();
// Assuming the first token you encounter is the START_OBJECT, otherwise start from 0.
int startEndCounter = 1;
//loop until the end object is found, simultaneously incrementing loop
while (startEndCounter != 0) {
    //...
    if (p.nextToken() == JsonToken.STAR_OBJECT) {
        startEndCounter++;    
    } else if (p.nextToken() == JsonToken.END_OBJECT) {
        startEndCounter--;    
    }
}
p.close();