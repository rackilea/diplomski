public static int convert(String str) {
    try{
        return Integer.parseInt(str.trim());
    }catch(Exception e) {
        return str.hashCode();
    }
}