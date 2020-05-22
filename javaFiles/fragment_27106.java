private String password;

@JsonIgnore
public String getPassword() {
    return password;
}

@JsonProperty
public void setPassword(String password) {
    this.password = password;
}