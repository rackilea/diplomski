String res = ""
String current = ""
for (char c : text.toCharArray()) {
    if(c == 'A' || c == 'B') {
        current += c + "";
    } else {
        if(current.length > res.length) {
            res = current;
        }
        current = "";
    }
}
if(current.length > res.length) {
    res = current;
}