try {
   int port = Integer.parseInt(input);
   // do something with the port
} catch (NumberFormatException e) {
   logger.error("'{}' is not a valid port number: {}", input, e.toString);
}