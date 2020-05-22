public static class MyApplicationSharedData {
private static ArrayList<String> locations = new ArrayList();

private static synchronized void writeLocation(String location) {
  locations.add(location);
}

public static void waitForLocation(String location) {
  while (locations.contains(location)) {
    try {
      Thread.sleep(1000);// sleep for a second while the location is bussy
    } catch (InterruptedException e) {
      log.error(e);
    }
  }
  writeLocation(location);
}

public static synchronized void freeLocation(String location) {
  locations.remove(location);
}