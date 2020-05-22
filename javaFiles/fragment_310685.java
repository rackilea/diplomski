mapper.configure(SerializationConfig.Feature.UNWRAP_ROOT_VALUE, true);
try
{
  Customer customer = mapper.readValue(jsonData, Customer.class);
}
catch (IOException ioe)
{
  //...
}