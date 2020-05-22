public class EventPubliserTest {

@Mock
private ObjectMapper objectMapper;

private class MockEventPublisher extends EventPublisher {
    @Override
    protected ObjectMapper getObjectMapper(boolean flag) {
        return objectMapper;
    }

}

@Test
public void testPublishEvent() throws Exception {
    EventPublisher eventPublisher = new MockEventPublisher();
    when(objectMapper.writeValueAsString(json)).thenThrow(mock(JsonProcessingException.class)); 
    //create or mock some json string
    eventPublisher.publishEvent(json);

    }
}