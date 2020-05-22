Yaml yaml2 = new Yaml();
Map map = yaml2.loadAs("master:\n  nodes:\n    - name: mystage", Map.class);
Map master = (Map) map.get("master");
List nodes = (List) master.get("nodes");
Map newNodes = new HashMap();
newNodes.put("nodes", nodes);
master.put("nodes", newNodes);
String modifiedDsl = yaml.dump(map);
MyDsl myDsl2 = yaml2.loadAs(modifiedDsl, MyDsl.class);