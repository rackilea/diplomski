@BeforeEach
void beforeEach() throws JsonProcessingException {
    mockMvc = MockMvcBuilders.standaloneSetup(outgoingMessageAPI)
            .addPlaceholderValue("MQTT_CLIENT_API_OUTGOING_MESSAGE", "/endpoint")
            .build();
    ...
}