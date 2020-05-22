JsonReader reader = new JsonReader(new StringReader(
            "[ {Name: \"ABC\", \"email\" : \"abc@123.com\", \"city\" : \"NewYork\"}, {Name: \"XYZ\", \"email\" : \"xyz@123.com\", \"city\" : \"NewJersey\"}]\n"));


    String target = "ABC";

    ArrayList<String> names = new ArrayList<String>();

    reader.setLenient(true);
    reader.beginArray();
    while(reader.hasNext()) {
        reader.beginObject();
        // peek is your best friend in this world, as it tells you what object you're looking at
        while(reader.peek() != JsonToken.END_OBJECT) {
            if(reader.peek() == JsonToken.NAME) {
                String name = reader.nextName();
                if(name.equals("Name")) {
                    if(reader.nextString().equals(target)) {
                        // I'm just printing these out right now but you could construct an object and set variables instead.
                        while(reader.peek() == JsonToken.NAME) {
                            switch (reader.nextName()) {
                                case "email":
                                    System.out.println("Found email for " + target + " " + reader.nextString());
                                    break;
                                case "city":
                                    System.out.println("Found city for " + target + " " + reader.nextString());
                                    break;

                            }
                        }
                    }

                }
            }
            //this is really the key to the parser which is to skip all the values that you're not interested in
            reader.skipValue();
        }


        reader.endObject();
    }
    reader.endArray();
}