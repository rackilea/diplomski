public String convert(String symbolString)  {
    StringBuilder sb = new StringBuilder();

    for(int k=0; k<symbolString.length(); k++){
        int origCode = Character.codePointAt(symbolString, k);
        Integer replaceCode = conversionTable.get(origCode);
        if(replaceCode != null) {
            sb.append(Character.toChars(replaceCode));
        } else {
            sb.append("?");
        }
    }

    return sb.toString();
}