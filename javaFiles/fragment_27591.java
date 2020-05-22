public static String strcat(String ori){
    return ori.substring(0, 4) + '-' + ori.substring(4, 6) + '-' + ori.substring(6);
}

public static String sdf(String ori){
    try {
        SimpleDateFormat in = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat out = new SimpleDateFormat("yyyy-MM-dd");
        Date temp = in.parse(ori);
        return out.format(temp);
    } catch (ParseException ex) {
        Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
}

public static String sb(String ori){
    return new StringBuilder(10).append(ori.substring(0, 4)).append('-').append(ori.substring(4, 6)).append('-').append(ori.substring(6)).toString();
}

public static String nio(String ori){
    byte[] temp = ori.getBytes();
    ByteBuffer bb = ByteBuffer.allocate(temp.length + 2);
    bb.put(temp, 0, 4);
    byte hyphen = '-';
    bb.put(hyphen);
    bb.put(temp, 4, 2);
    bb.put(hyphen);
    bb.put(temp, 6, 2);
    return new String(bb.array());
}

public static String qd(String ori){
    char[] result = new char[10];
    result[4] = result[7] = '-';

    char[] temp = ori.toCharArray();
    System.arraycopy(temp, 0, result, 0, 4);
    System.arraycopy(temp, 4, result, 5, 2);
    System.arraycopy(temp, 6, result, 8, 2);
    return new String(result);
}

public static void main(String[] args) {
    String ori = "20110913";
    int rounds = 10000;
    for (int i = 0; i < rounds; i++) {
        qd(ori);
        nio(ori);
        sb(ori);
        sdf(ori);
        strcat(ori);
    }
}