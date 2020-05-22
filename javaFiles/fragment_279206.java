Field f = R.class.getField("_1st");
Class<?> t = f.getType();
if(t == int.class){
    System.out.println(f.getInt(null));
}else if(t == double.class){
    System.out.println(f.getDouble(null));
}...