DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSS");
SimpleModule simpleModule = new SimpleModule();
simpleModule.addSerializer(new LocalDateTimeSerializer(dateTimeFormatter));

final ObjectMapper mapper = new ObjectMapper();
mapper.registerModule(simpleModule);

final LocalDateTime t = LocalDateTime.of(2014, 3, 30, 12, 30, 23, 123456789);

System.out.println(mapper.writeValueAsString(t));