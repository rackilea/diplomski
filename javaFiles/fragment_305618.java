Json json = new Json();

json.setTypeName(null);
json.setUsePrototypes(false);
json.setIgnoreUnknownFields(true);
json.setOutputType(OutputType.json);

json.toJson(config, GameConfig.class);