public class test {

    public static void main(String[] args) {
        Object[][] someArray = new Object[5][];
        someArray[0] = new Object[10];
        someArray[1] = null;
        someArray[2] = new Object[1];
        someArray[3] = null;
        someArray[4] = new Object[5];

        for (int i=0; i<=someArray.length-1; i++) {
            if (someArray[i] != null) {
                System.out.println("not null");
            } else {
                System.out.println("null");
            }
        }
    }
}