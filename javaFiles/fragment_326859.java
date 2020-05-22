B createB(File f){
    ...
    String type = ...
    Class clazz = typemap.get(type);
    if (clazz == null){
        return null;
    }

    B newB = clazz.getConstructor(/*arg types*/).newInstance(/*args*/);
    return newB;
}