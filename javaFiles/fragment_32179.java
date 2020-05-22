MeterRates rates = new MeterRates();
    rates.setRate1024(0.7654);
    rates.setRate51200(0.4567);
    ObjectMapper objectMapper = new ObjectMapper();
    String s = objectMapper.writeValueAsString(rates);
    System.out.println("s = " + s);
    MeterRates m = objectMapper.readValue(s, MeterRates.class);
    System.out.println("m = " + m);