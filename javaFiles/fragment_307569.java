DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

    Map<String, String> map = new HashMap<>();
    map.put("10/11/2015", "A");
    map.put("10/12/2015", "B");
    map.put("10/13/2015", "C");
    map.put("10/14/2015", "D");
    map.put("10/15/2015", "E");

    TreeMap<Calendar, String> tree = new TreeMap<Calendar, String>();

    for (Map.Entry<String, String> entry : map.entrySet()) {
        System.out.println(entry);
        String key = entry.getKey();
        String value = entry.getValue();

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(formatter.parse(key));
        tree.put(calendar, value);
    }

    for (Calendar key : tree.keySet()) {
        System.out.println(key.getTime());
    }