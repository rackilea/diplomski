public class t1 implements MouseListener
    { 
    static TextArea textArea;
    static Frame frame;
        public static void main(String[] args)
        {
        // Create frame with title
          frame = new Frame("Click Counter Project");

            // Create a component to add to the frame
             textArea = new TextArea("Click");
             t1 clickCount= new t1();
        }
    ...
 t1()
    {
        frame.add(textArea, BorderLayout.NORTH);
            int width = 300;
            int height = 300;
            frame.setSize(width, height);
            frame.addMouseListener(this);
            frame.setVisible(true);
    }
    }