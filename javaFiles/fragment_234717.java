Pattern p = Pattern.compile("((\\d+)h)?((\\d+)m)?((\\d+)s)");
Matcher m = p.matcher("1h15m17s");
if (m.find()){
    Integer hour = Integer.valueOf(m.group(2));
    Integer minute = Integer.valueOf(m.group(4));
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(hour + " - " + minute + " - " + second);
}

m = p.matcher("1h0m5s");
if (m.find()){
    Integer hour = Integer.valueOf(m.group(2));
    Integer minute = Integer.valueOf(m.group(4));
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(hour + " - " + minute + " - " + second);
}

m = p.matcher("15m0s");
if (m.find()){
    Integer minute = Integer.valueOf(m.group(4));
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(minute + " - " + second);
}

m = p.matcher("12s");
if (m.find()){
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(second);
}

m = p.matcher("0s");
if (m.find()){
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(second);
}