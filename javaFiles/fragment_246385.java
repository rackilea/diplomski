String dataArray[] = data.split(",");
    byte[] bytes = new byte[dataArray.length];
    int count = 0;
    for(String str : dataArray)
    {
        bytes[count++] = Byte.parseByte(str);
    }