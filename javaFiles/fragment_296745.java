String s = "{ items: [\n" +
        "    { id: 1, name: 'test1' }, \n" +
        "    { id: 2, name: 'test2' }\n" +
        "] }";
Map map = (Map) new Yaml().load(s);
System.out.println(map);