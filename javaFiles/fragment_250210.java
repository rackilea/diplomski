HashMap<String,String> pairs= new HashMap<String,String>();
    Constants constants= new Constants();
    Field[] f = constants.getClass().getFields();
    for (int i = 0; i < f.length; i++) {
        pairs.put(f[i].getName().toLowerCase(),f[i].get(constants).toString());
    }
    System.out.println(pairs);