public class Test extends JFrame{

    public Test(){

        JTree tree = new JTree();

        JScrollPane pane = new JScrollPane(tree);

        //To control the needed behavior when drag is finished, override 
        //mouse released in DragScrollListener by extending it
        MyDragScrollListener ds = new MyDragScrollListener(tree);

        tree.addMouseListener(ds);
        tree.addMouseMotionListener(ds);

        getContentPane().add(pane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        this.setSize(100,100);
    }

    //Subclass DragScrollListener to override mouse released 
    public class MyDragScrollListener extends DragScrollListener{

        public MyDragScrollListener(Component c) {
            super(c);
        }

        @Override
        public void mouseReleased(MouseEvent e){

            //add needed functionality when mouse is released 
            if( e.getSource() instanceof JTree) {

                System.out.println("source is a JTree");
                JTree tree = (JTree)e.getSource();

                //clear seelction
                 tree.clearSelection(); 

            }

            super.mouseReleased(e);
        }
    }

    public static void main(String[]arghs){
        new Test();
    }
}