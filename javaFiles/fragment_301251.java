DynamicType t = new DynamicType("t");
t.addField("name", null);
t.addField("age", null);

Dynamic t1 = t.createInstance();
Dynamic t2 = t.createInstance();

t.addField("sex", "male"); //Now both t1 and t2 have sex -> male