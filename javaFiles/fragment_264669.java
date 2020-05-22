public static class DefaultFruit {
    public String taste;
}

public static class Fruit {
    @JsonUnwrapped
    public DefaultFruit fruit;
    public String color;
}

@Test
public void serialize_unwrapped() throws Exception {
    Fruit fruit = new Fruit();
    fruit.color = "red";
    fruit.fruit = new DefaultFruit();
    fruit.fruit.taste = "sweet";
    assertThat(mapper.writeValueAsString(fruit),
               equalTo("{\"taste\":\"sweet\",\"color\":\"red\"}"));
}