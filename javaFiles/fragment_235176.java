public static String[] getNameList(){
    String[] names = new String[dbTypes.length];
    for(int i=0; i<dbTypes.length; i++){
        Field f = dbTypes[i].getField("NAME");
        names[i] = f.get(null);
    }
    return names;
}