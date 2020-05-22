Iterator iterator = pingUrlTimes.keySet().iterator(); // Get Iterator

while (iterator.hasNext()) {
    String key = (String) iterator.next();

    System.out.println(key + "=" +  pingUrlTimes.get(key) );
}