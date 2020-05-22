class HelloWorld extends JPanel implements KeyListener{
    public void keyTyped(KeyEvent e) {
        System.out.println("keyTyped: "+e);
    }
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed: "+e);
    }
    public void keyReleased(KeyEvent e) {
        System.out.println("keyReleased: "+e);
    }
}

class MyFrame extends JFrame {
    public MyFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(200,200);

        HelloWorld helloWorld=new HelloWorld();

        helloWorld.addKeyListener(helloWorld);
        helloWorld.setFocusable(true);

        add(helloWorld);
        setVisible(true);
    }
    public static void main(String[] args) {
        new MyFrame();
    }
}