public String getText(){
    int count = mAddress.size();

    StringBuilder str = new StringBuilder((count+2)*16);

    str.append("DMX : ADDRESS  \n"); //16
    str.append("--- : ---------\n"); //16

    for (int i = 0; i < count ; i++)
        str.append(String.format("%03d : %s\n", mAddress.get(i), mBits.get(i)));
    return str.toString();