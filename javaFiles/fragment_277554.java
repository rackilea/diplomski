if (tag == Tag.A) {
  String address = (String) attribute.getAttribute(Attribute.HREF);
  //if(!address.startsWith("http"))  should work too as a primitive absolute link 
  //often starts with "http" as protocol
  if(address.startsWith("/")||address.startsWith("..")){
    address = baseUrl + address;
  }  
  list.add(address);
}