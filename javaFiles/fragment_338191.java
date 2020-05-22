String json = "{\r\n" + 
              "  \"cron\" : \"someCronString\",\r\n" + 
              "  \"overrides\" : [ \"someCronString1\", \"someCronString2\" ]\r\n" + 
              "}";
ScheduleConfigurations configObj = new ObjectMapper().readValue(json, ScheduleConfigurations.class);
System.out.println("cron = " + configObj.getCron());
System.out.println("overrides = " + configObj.getOverrides());