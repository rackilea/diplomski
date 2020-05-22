class MainClass {
    public static void main(String[] args) {
        StringBuilder c = new StringBuilder("lalala");
        changeString(c);
        System.out.println("str in main = "+c.toString());
    }

    public static void changeString(StringBuilder str) {
        str.append("CHANGE!!!");
        System.out.println("str in changeString = "+str.toString);
    }

}