public String addToString(String source, char separator, String toBeInserted) {
        int index = source.lastIndexOf(separator); 
        if(index >= 0&& index<source.length())
    return source.substring(0, index) + toBeInserted + source.substring(index);
        else{throw indexOutOfBoundsException;}
}