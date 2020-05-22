public class Test {

    public void printPhoto(int width, int height, boolean inColor) {
        System.out.println("Width = " + width + " cm");
        System.out.println("Height = " + height + " cm");
        if (inColor) {
            System.out.println("Print is Full color.");
        } else {
            System.out.println("Print is black and white.");
        }
        // printPhoto(10, 20, false); // Avoid a Stack Overflow due the recursive call
    }

    //main class
    public static void main(String[] args) {
        Test tst = new Test();//create a new instance of your class
        tst.printPhoto(0, 0, true);//call your method with some values        
    }

}