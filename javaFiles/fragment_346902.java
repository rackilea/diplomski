static void charlie(String alice, boolean bob) {
    HashMap<String, Object> arguments = new HashMap<>();
    arguments.put("alice", alice);
    arguments.put("bob", bob);
    channel.invokeMethod("charlie", arguments);
  }