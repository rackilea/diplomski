jshell> class Player{
   ...> Object someObject;
   ...> HashMap<Integer,String> someMap;
   ...> {
   ...> someMap = new HashMap<>();
   ...> someMap.put(1,"Player");
   ...> }
   ...> }
|  modified class Player

jshell> 

jshell> 

jshell> Player player = new Player();
player ==> Player@71423665

jshell>         java.lang.reflect.Field[] fields = player.getClass().getDeclaredFields();
fields ==> Field[2] { java.lang.Object Player.someObject, ja ... l.HashMap Player.someMap }

jshell>         for(java.lang.reflect.Field field : fields) {
   ...>             // Check if field is a HashMap
   ...>             if(field.getType().equals( HashMap.class)) {
   ...> 
   ...>                 HashMap<Integer,String> data = (HashMap<Integer,String>)(field.get(player));
   ...>                 data.remove(1);
   ...>                 System.out.println("Data left in map is "+data.size());
   ...>             }
   ...>         }
Data left in map is 0