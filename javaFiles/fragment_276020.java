f.addWindowListener(new WindowAdapter() {
    public class MyMouseListener2 extends MouseAdapter {

        public void mouseClicked(MouseEvent m) {
            System.exit(0);
        }
    }
});