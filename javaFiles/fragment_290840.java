HashMap<String, Integer> m = new HashMap<>();
//...
//for first time ID
m.put("ID as string",1);
//...
//Counting on more ID
m.replace("ID as string",m.get("ID as string")+1);