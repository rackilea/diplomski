for (JsonElement jsonElement : jsonArray) {
    JsonObject jsonObject = (JsonObject) jsonElement;
    String name = jsonObject.get(technologyX.getTechnologyId() + "").getAsString();
    System.out.println("The name of technology witch Id = " + technologyX.getTechnologyId() + " is : "
            + name);
}