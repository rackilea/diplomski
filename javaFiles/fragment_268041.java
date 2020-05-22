public class JavaUtilsTests {

    static public class C1
    {

        public C1(int x, int y) {
            this.x = x;
            this.y = y;
        }       

        public int getX() { return x; }
        public void setX(int x) { this.x = x; }

        public int getY() { return y; }
        public void setY(int y) { this.y = y; }

        private int x;
        private int y;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        C1 o1 = new C1(1,2);
        Map<String, Object> attributesMap = Serializer.object2Map(o1);
        System.out.printf("x=%s\ty=%s\n", attributesMap.get("x"), attributesMap.get("y"));
    }
}