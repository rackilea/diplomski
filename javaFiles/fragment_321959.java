public static void main(String[] args) throws Exception {
    Operation op=getInstance();
    op.setData("test1");
    byte[] ds=serialize();
    System.out.println(new Date(getInstance().timestamp));
    op.setData("test2");
    deserialize(ds);
    System.out.println(getInstance().getData());

}