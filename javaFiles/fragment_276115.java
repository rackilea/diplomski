StringBuilder result = new StringBuilder(str.length());
result.append(parts[0]); //First part always exists.
int pos = parts[0].length + 1; //Skip past the first entity and the ampersand.
for(int i = 1;i < parts.length;i++) {
    String entityName = str.substring(pos,str.indexOf(';',pos));
    if(entityName.matches("x[A-Fa-f0-9]+") && entityName.length() <= 5) {
        result.append((char)Integer.decode("0" + entityName));
    } else if(entityName.matches("[0-9]+")) {
        result.append((char)Integer.decode(entityName));
    } else {
        switch(entityName) {
            case "euml": result.append('ë'); break;
            case "auml": result.append('ä'); break;
            ...
            default: result.append("&" + entityName + ";"); //Unknown entity. Give the original string.
        }
    }
    result.append(parts[i]); //Append the text after the entity.
    pos += entityName.length() + parts[i].length() + 2; //Skip past the entity name, the semicolon and the following part.
}
return result.toString();