m = p.matcher("0s");
if (m.find()){
    Integer minute = Integer.valueOf(m.group(4)); //exception here
    Integer second = Integer.valueOf(m.group(6));
    System.out.println(second);
}