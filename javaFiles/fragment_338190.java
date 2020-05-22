ScheduleConfigurations configObj = new ScheduleConfigurations();
configObj.setCron(new Cron("someCronString"));
configObj.setOverrides(new LinkedHashSet<>(Arrays.asList(
        new Cron("someCronString1"), new Cron("someCronString2"))));
ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
System.out.println(mapper.writeValueAsString(configObj));