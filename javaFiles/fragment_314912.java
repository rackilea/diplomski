try{
            JsonReader reader = Json.createReader(in);
            // ... do stuff
        }
        catch(JsonParsingException exception) {
            String msg = "JsonParsingException: " + exception.getLocalizedMessage();
            msg += " (could be caused by a premature EOF if the client timed out too quickly)";
            logMessage(msg);                
        }