StringBuilder strb = new StringBuilder();
    while ((value = inputStream.read()) != -1) {
        if(value != 0)
            strb.append((char) value);
        System.out.print(value + ":" + (char) value+",");
    }
    return strb.toString();