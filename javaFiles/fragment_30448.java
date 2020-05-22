try(InputStream inputStream =Thread.currentThread().getContextClassLoader().getResourceAsStream(Constants.MessageInput)){
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readValue(inputStream ,
                    JsonNode.class);
            json = mapper.writeValueAsString(jsonNode);
        }
        catch(Exception e){
            throw new RuntimeException(e);
        }