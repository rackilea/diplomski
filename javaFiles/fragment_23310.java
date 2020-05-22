@MessageMapping("/hello")
@SendTo("/topic/greetings")
public  GenericMessage<Greeting> greeting(HelloMessage message) throws Exception {      
    Map<String, List<String>> nativeHeaders = new HashMap<>();
    nativeHeaders.put("hello", Collections.singletonList("world"));

    Map<String,Object> headers = new HashMap<>();
    headers.put(NativeMessageHeaderAccessor.NATIVE_HEADERS, nativeHeaders);

    return new GenericMessage<Greeting>(new Greeting("Hello, " + message.getName() + "!"), headers);
}