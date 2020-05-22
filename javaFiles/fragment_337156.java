List<WeatherDto> dtos = new ArrayList<>();
Iterator<JsonNode> itr = weatherNode.get("data").elements();

 while(itr.hasNext()) {

    JsonNode node = its.next();
    WeatherDto weatherDto = new WeatherDto();

       // set all values to weatherDto
    weatherDto.setCity(city);
    weatherDto.setDate(LocalDate.parse(node.get("valid_date").textValue()));
    weatherDto.setTemperature(node.get("temp").intValue());
    weatherDto.setCloudiness(node.get("clouds").intValue());
    weatherDto.setRainfall(node.get("pop").intValue());

    // finally add that dto to List
    dtos.add(weatherDto);

   }

 return dtos;