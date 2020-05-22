Type mapType = new TypeToken<Map<String, String>>() {
}.getType();
String string = "{health=0.6, mana=1, dam=12%, life=0.3, xp=17%, loot=17%}";
Map<String, String> map = new Gson().fromJson(string, mapType);
for (String key : map.keySet()) {
    System.out.println(key + ":" + map.get(key));
}