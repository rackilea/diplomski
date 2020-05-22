public static boolean isString(Object input){
    try{
        String str = (String) input;
        return true;
    }catch(ClassCastException ex){
        return false;
    }
}