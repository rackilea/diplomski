public static void main(String[] args) throws Exception {
    Input user = new Input();
    user.setId("0001");
    user.setType("donut");
    user.setName("Cake");
    user.setPpu(0.55);

    // Add Regular batter
    Batter batter1 = new Batter();
    batter1.setId("0001");
    batter1.setType("Regular");

    // Add Devil's Food batter
    Batter batter2 = new Batter();
    batter2.setId("1004");
    batter2.setType("Devil's Food");

    Batters batters = new Batters();
    batters.setBatter(Arrays.asList(batter1, batter2));
    user.setBatters(batters); 

    // Add toppings
    Topping topping1 = new Topping();
    topping1.setId("5001");
    topping1.setId("None");

    Topping topping2 = new Topping();
    topping2.setId("5004");
    topping2.setId("Maple");

    users.setTopping(Arrays.asList(topping1, topping2));

    ObjectMapper mapper = new ObjectMapper();
    mapper.enable(SerializationFeature.INDENT_OUTPUT);

    String json = mapper.writeValueAsString(user);
    System.out.println(json); // expected string