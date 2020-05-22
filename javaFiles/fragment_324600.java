String ipAddress = input.nextLine();
boolean ipValid = Arrays
  .stream(ipAddress.split("\\."))
  .mapToInt(Integer::parseInt)
  .filter(x -> x >= 0 && x <= 255) // remove invalid numbers
  .toArray().length == 4; // if the resulting length is 4, the ip is valid