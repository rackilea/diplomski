ConcurrentHashMap messages = null;
synchronized (context) {
    ConcurrentHashMap messages =(ConcurrentHashMap)context.getAttribute("map");
}
String mes  = messages.get("id");  // can be changed by another thread?
messages.put("id",mes +"changed by thread 1");