@Override
  public String getContact(@PathVariable String vendorName) {
    System.out.println("Got: " + vendorName);

    return "Hello " + vendorName;
  }