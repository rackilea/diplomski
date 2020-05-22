ModelMapper modelMapper = new ModelMapper();
modelMapper.addMappings(new PropertyMap<Order, OrderDTO>() {
  protected void configure() {
    map().setBillingStreet(source.getBillingStreetAddress());
    skip().setBillingCity(null);
  }
});