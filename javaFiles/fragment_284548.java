...
    GsonBuilder gsonBuilder = new GsonBuilder();
    new GraphAdapterBuilder()
            .addType(ClassA.class)
            .addType(ClassB.class)
            .registerOn(gsonBuilder);
    gson = gsonBuilder.create();
    СlassB B = gson.fromJson(json,ClassB.class);

    System.out.println("B " + B.vector);
    for(ClassA classA:B.vector){
        System.out.println(classA.field + "  " + classA.parent);
    }