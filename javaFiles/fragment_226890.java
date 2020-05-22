public static int getKeyEventVK(char c) throws 
                      IllegalArgumentException, SecurityException, 
                      IllegalAccessException, NoSuchFieldException {
    return KeyEvent.class.getField("VK_" + 
               String.valueOf(c).toUpperCase()).getInt(null);

}

public static void main(String[] args) throws Exception{
    System.out.println(getKeyEventVK('h'));
    System.out.println(KeyEvent.VK_H);
}