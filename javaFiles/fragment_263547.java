public static ErrorType createStory(@NonNull String name){
    Matcher m = Pattern.compile(INVALID_PATTERN).matcher(name);
    if(m.find()){
        Log.e("Error", "Story name '" + name + "' contains illegal characters.");
        return ErrorType.ILLEGAL;
    }
    //...
}