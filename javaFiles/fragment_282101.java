public static void main(String[] args) throws JsonProcessingException {
        ArrayList<String> values = new ArrayList<>();
        values.add("LevelOne | LevelTwo");
        values.add("LevelOne |LevelThree");
        values.add("LevelTwo | LevelFour");
        values.add("LevelTwo |LevelFive");
        values.add("LevelFour |LevelSix");

        ObjectMapper mapper = new ObjectMapper();

        ArrayNode arrayNode = new ArrayNode(JsonNodeFactory.instance);

        for(String value : values){
            String parent = value.substring(0,value.indexOf("|")).trim();

            if(!arrayNode.findValuesAsText("folder").contains(parent)) {
                buildNode(values, mapper, arrayNode, parent);
            }

        }
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(arrayNode));
    }