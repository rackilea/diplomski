public int countSubstring(String subStr, String str){
    int count = 0;
    for (int loc = str.indexOf(subStr); loc != -1;
         loc = str.indexOf(subStr, loc + subStr.length()))
        count++;
    return count;
}