HashMap<String,String> pairs= new HashMap<String,String>();
    for(Field field :Constants.class.getFields())
    { 
        pairs.put(field.getName().toLowerCase(),field.get(null).toString());
    }
    System.out.println(pairs);