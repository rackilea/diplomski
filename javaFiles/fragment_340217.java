@GetMapping
public MappingJacksonValue getUser(){
    User user = new User();
    MappingJacksonValue value = new MappingJacksonValue(user);
    value.setSerializationView(User.Activity.class);
    return value;
}