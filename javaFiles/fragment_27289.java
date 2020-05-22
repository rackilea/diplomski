JsonView<List<ScreenInfoPojo>> viwevedObject = JsonView
        .with(screens)
        .onClass(ScreenInfoPojo.class,
                Match.match()
                        .exclude("*")
                        .include("id","name")
                        .include("createdBy.name")
                        .include("lastUpdatedBy.mobileNo")
                        .include("parentScreen.id"))
        .setIgnorePathIfClassRegistered(false);

ObjectMapper mapper = new ObjectMapper().registerModule(new JsonViewModule());
mapper.configure(SerializationFeature.INDENT_OUTPUT, true);

String json = mapper.writeValueAsString(viwevedObject);