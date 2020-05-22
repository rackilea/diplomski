public void LoadSaveString() throws IOException {
    ObjectMapper mapper = new ObjectMapper();
    SimpleModule module = new SimpleModule();
    mapper.registerModule(module);

    String filePath = "files/SaveFile.json";

    //Read the whole file and not just one line
    byte[] encoded = Files.readAllBytes(Paths.get(filePath));
    String testfile = new String(encoded, "utf-8");

    JSONObject json = new JSONObject(testfile);
    //Pick only the player part
    String playerPart = json.getJSONObject("player").toString();

    System.out.println("Stringen testfilen bliver printet: " + testfile);
    Player player1 = (Player) mapper.readValue(playerPart, Player.class);
    System.out.println("Test 2: " + player1.toString());

}