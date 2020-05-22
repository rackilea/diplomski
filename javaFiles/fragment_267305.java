String str = "someContent";
String newStr = "";
int level = 0;
for (int i = 0; i < str.length(); ++i){
    if (str.charAt(i) == '{'){
        if (level == 0) //check before incrementing
            newStr += "{";
        level++;
    } else if (str.charAt(i) == '}'){
        level--;
        if (level == 0) //check after incrementing
            newStr += "}";
    } else {
        newStr += str.charAt(i);
    }
}

return newStr;