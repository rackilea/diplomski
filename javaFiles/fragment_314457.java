@JsonCreator
public static Role fromJson(String value){
    Role role = new Role();
    role.setRole(value);
    return role;
}

@JsonValue
public String toJson() {
    return role;
}