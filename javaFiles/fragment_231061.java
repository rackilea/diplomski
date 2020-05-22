public static boolean isParsable(String input){
    try{
        Integer.parseInt(input);
        return true;
    }catch(ParseException e){
        return false;
    }
}