String[] tmp = yourString.Split("\\.|/| ");
for (int i=0; i< tmp.length(); i++) {
    if (tmp[i].matches("^Module.*")) {
       return tmp[i];
    }
}
return null;