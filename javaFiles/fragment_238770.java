HttpEntity entity = response.getEntity();

    JsonFactory jsonf = new JsonFactory();

    // try with resource is not strictly necessary here 
    // but is a good practice
    try(InputStream instream = entity.getContent()) {            JsonParser jsonParser = jsonf.createParser(instream);
        // Use the parser to deserialize the object from the content stream
        return stuff;
    }