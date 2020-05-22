public static void main(String[] args) throws IOException, InvalidSyntaxException {

    StringBuffer text = new StringBuffer();
    BufferedReader br = new BufferedReader(new InputStreamReader(JSON.class.getResourceAsStream("json.txt")));

    String output; // API output

    System.out.println("Output from Server .... \n");
    while ((output = br.readLine()) != null) {
        System.out.println(output);
        text.append(output);
    }

    System.out.println(text);
    JsonRootNode rootNode = new JdomParser().parse(text.toString());
    List<JsonNode> results = rootNode.getArrayNode("results");
    JsonNode firstUserMap = results.get(0);
    JsonField user = firstUserMap.getFieldList().get(0);
    JsonNode userNode = user.getValue();
    JsonField name = userNode.getFieldList().get(1);
    JsonNode nameNode = name.getValue();
    JsonField firstName = nameNode.getFieldList().get(1);
    System.out.println(firstName.getValue().getText());

}