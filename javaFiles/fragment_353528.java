Map map = new HashMap();
Gson gson = new GsonBuilder().disableHtmlEscaping().create()

....

List<Event> result = service.getEvents(cat, Integer.parseInt(start), Integer.parseInt(step));

map.put("result", result);

String objs = gson.toJson(map);