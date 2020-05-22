public String getProductCode(){
    Random random = new Random();
    int first = random.nextInt(26) + 65;  //Get random ASCII code in letter range
    char firstChar = new Character((char) first);  //Convert to char
    int suffix = 10000 + random.nextInt(89999);  //Get 5 digit suffix
    return Character.toString(firstChar) + String.valueOf(suffix);
}