Object result = client.execute(...);
if (result instanceof Integer) {
  Integer intResult = (Integer) result;
  ... handle int result
}    
else if (result instanceof Object[]) {
  obj = (Object[]) result;
}
else {
  ... something else
}