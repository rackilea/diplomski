String json = "{\"_values\":{\"business\":{\"purpose\":{\"default\":5.2},\"vehicle\":"
            + "{\"automobile\":0.0,\"bicycle\":0.0,\"motorcycle\":0.0}},\"personal\":"
            + "{\"purpose\":{\"charity\":0.728,\"medical\":1.222,\"moving\":1.222}}}}";

ObjectMapper mapper = new ObjectMapper();
Data data = mapper.readValue(json, Data.class);