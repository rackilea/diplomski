public class JavaGui {

    JFrame frame;

    public JavaGui() {
        GraphicsConfiguration g = null;
        frame = new JFrame(g);  
        frame.setTitle("gui");
        frame.setSize(600, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLayout(null);  
    }

    public void createButton(){
        JButton button = new JButton();
        button.setBounds(130,100,100, 40); 
        button.setText("aaa");
        button.setSize(100, 40);
        button.setLayout(null);

        frame.add(button);      
     }

    public static void main(String[] args) {
        JavaGui gui = new JavaGui();
        gui.createButton();     
    }
}