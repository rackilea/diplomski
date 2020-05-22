public static void main(String[] args)
{
    String jsonString = "{ \"name\": \"dunnosName\"," + "\"widthValue\": 46.1," + "\"heightValue\": 56.1,"
            + "\"depthValue\": 66.1," + "\"unit\": \"mm\"}";

    ObjectMapper mapper = new ObjectMapper();
    try {
        Dunno d = (Dunno)mapper.readValue(jsonString, Dunno.class);
        System.out.format("%s: %.2f(%s) %.2f(%s) %.2f(%s)", 
                d.name, d.width.value, d.width.unit, d.height.value, d.height.unit, d.depth.value, d.depth.unit);

    } catch (IOException e) {
        e.printStackTrace();
    }
}