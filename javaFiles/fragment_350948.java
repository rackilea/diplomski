for:  {"A":1}  use: new BasicDBObject("A",1)
for: {"A":1, "B":2}  use: new BasicDBObject("A",1).append("B",2)
for: {"A":{"B":2}}  use: new BasicDBObject("A",new BasicDBObject("B",2))
for: {"A":["B","C"]} use:
        BasicDBList dbl = new BasicDBList();
        dbl.add("B");
        dbl.add("C");
         ->  new BasicDBObject("A",dbl);