@MessageMapping("/path1")
@SendTo("/queue/path1-data")
public String myController(String message) throws Exception {
    Gson gson = new Gson();
    return gson.toJson(new BrokerPacket(message, "sdf", "asdf"));
}