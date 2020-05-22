public class Window_Controller
{
....
 public Window_Controller() throws HeadlessException {

            addMouseListener(this);
        addWindowListener(close);

        setTitle("Binary Trees - Alpha Stage");
        setSize(1200, 700);
        setLocation(40, 0);
        setVisible(true);

        incrementButton = new Button("+1", Color.white, deLoc - 47, y, 45);
        decrementButton = new Button("-1", Color.white, deLoc, y, 45);
        fullButton = new Button("Full Binary Tree", Color.cyan, x, y, 110);
        completeButton = new Button("Complete Binary Tree", Color.green, x + 130, y, 150);
        // I think this is the problem
        //fullTree = new Full_Binary_Tree();//Don't create object of Full_Binary_Tree here.
    }
  public synchronized void createFullBinaryTreeInstance()
  {
    if (fullTree == null)
    fullTree = new Full_Binary_Tree();
  }
}