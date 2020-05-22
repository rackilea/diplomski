@JsonProperty("customer")
public Long getCustomerId(){
  if (customer != null){
    return customer.getId();
  }
  else {
    return null;
  }
}