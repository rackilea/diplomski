JAXBContext context = JAXBContext.newInstance(SomeRoot.class);
         Unmarshaller unMarshaller = context.createUnmarshaller();
         File file = ResourceUtils.getFile("classpath:config/SomeRoot.xml");
         SomeRoot param = (SomeRoot) unMarshaller.unmarshal(file);
         List<Schedule> schedules = param.getSchedule(); 
         for (Schedule schedule : schedules) { 
           LOGGER.info("Schedule: "+schedule.getId()); 
         }