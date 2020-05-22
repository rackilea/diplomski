private static final long serialVersionUID = 1L;

// I made all components static since you only need one copy of each
private static JLabel num; //tells user to enter number of nodes
private static JTextField in; //text field for user input
private static JButton enter = new JButton("Enter");// create a button to capture event

private static Tree tempTree; 

private int nodeNumber;   // makes a tree's node number changeable

public Tree() {

    this.nodeNumber = 0;
    num = new JLabel("Number of Branches: ");
    add(num);
    in = new JTextField(5);
    add(in);
    add(enter);
    add(enter);
}



private void draw(Graphics2D g, int n, int x, int y) {
    if (n == 0) {
        return;
    } else {
        int angle = 45;
        int length = 50;
        g.drawLine(x, y, x, y - length); // trunk
        g.setColor(Color.BLACK);
        g.rotate(Math.toRadians(-angle), x, y - length); // left
        // branch
        draw(g, n - 1, x, y - length);
        g.rotate(Math.toRadians(angle), x, y - length);
        g.rotate(Math.toRadians(angle), x, y - length); // right
        // branch
        draw(g, n - 1, x, y - length);
        g.rotate(Math.toRadians(-angle), x, y - length);
    }
}

// I had to overload your draw method to one in which I can change the drawing multiple times later
private void draw(Graphics2D g, int x, int y)
{
        int n = this.nodeNumber;
       if (n == 0) {
           return;
       } else {
           int angle = 45;
           int length = 50;
           g.drawLine(x, y, x, y - length); // trunk
           g.setColor(Color.BLACK);
           g.rotate(Math.toRadians(-angle), x, y - length); // left
           // branch
           draw(g, n - 1, x, y - length);
           g.rotate(Math.toRadians(angle), x, y - length);
           g.rotate(Math.toRadians(angle), x, y - length); // right
           // branch
           draw(g, n - 1, x, y - length);
           g.rotate(Math.toRadians(-angle), x, y - length);
       }
}

//makes a tree's node number editable
public void setNodeNumber(int number)
{
    this.nodeNumber = number;
}

protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D gg = (Graphics2D) g;

    //this version can change node number
    draw(gg,getWidth() / 2, getHeight() / 2);
}

public static void main(String[] args) {

    Tree tree = new Tree();
    tree.setPreferredSize(new Dimension(500, 500));
    JFrame frame = new JFrame("Test");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().add(tree);
    frame.setSize(500, 500);

    // stores the currently displayed tree for later changes
    Tree.tempTree = tree;
    Listener enterListener = new Listener();

    Tree.enter.setActionCommand("ENTER");
    Tree.enter.addActionListener(enterListener);


    frame.setLocationRelativeTo(null);
    frame.setVisible(true);


}

// refreshes tree
public static void refreshTree()
{



    int inputNumber;

    // checks if input is a number or not
    try
    {
        //gets input node number 
        inputNumber =  Integer.parseInt(Tree.in.getText());

        //sets node number 
        Tree.tempTree.setNodeNumber(inputNumber);
        // updates tree
        Tree.tempTree.updateUI();
    }
    catch(NumberFormatException e)
    {
        System.out.println(" Invalid node Number " + e);
    }



}