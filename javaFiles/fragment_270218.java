import java.awt.Component;
    import java.awt.event.FocusEvent;
    import java.awt.event.FocusListener;
    import javax.swing.JFrame;
    import javax.swing.JScrollPane;
    import javax.swing.JSplitPane;
    import javax.swing.JTextPane;
    import javax.swing.JTree;
    import javax.swing.KeyStroke;
    import javax.swing.tree.DefaultTreeCellEditor;
    import javax.swing.tree.DefaultTreeCellRenderer;
    import javax.swing.tree.TreeCellRenderer;


    public class StackExchangeQuestion3AnsA {

         public static void main(String[] args){  
         new StackExchangeQuestion3AnsA();           
         }        


   StackExchangeQuestion3AnsA(){
         JFrame window;    
         window = new JFrame();
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.setTitle("Stack Exchange Answer");
         window.setSize(400,500);//variable parameters would be best
         window.setVisible(true);           


         JSplitPane split = new JSplitPane();
       window.setContentPane(split);
         JScrollPane left = new JScrollPane();
         JScrollPane right = new JScrollPane();
         JTree tree;
         tree = new JTree();//loads sample tree data
         tree.setEditable(true);//select a node then press F2 to edit (built in keybinding)
         tree.getInputMap().put(KeyStroke.getKeyStroke("SPACE"), "startEditing");//can edit with space now
         tree.setInvokesStopCellEditing(true);//this helps stop editing within focus of tree
         //even with my fix the above line is still needed

         JTextPane text = new JTextPane();
         split.setLeftComponent(left);
         split.setRightComponent(right);
         left.setViewportView(tree);
         right.setViewportView(text);
         split.setDividerLocation(200);   

         tree.setCellEditor( new MyTreeCellEditor(tree, tree.getCellRenderer()) );

   }//end constructor


private class MyTreeCellEditor extends DefaultTreeCellEditor {
     public MyTreeCellEditor(JTree tree, TreeCellRenderer renderer) {
                    super(tree, (DefaultTreeCellRenderer)renderer);
//Note: http://stackoverflow.com/questions/5031101/why-i-lose-the-focus-for-a-short-time-from-jtree-after-editing-a-node?rq=1 
//André mentions "The tree adds a DefaultCellEditor to the JTree hierarchy when editing starts. This textfield gains the focus."                    
//it's not as simple as just this.addFocusListener()

//2 variables: editingComponent and editingContainer, are inherited from DefaultTreeCellEditor
//the constructor doesn't initialize the editingComponent
//it's null atm, so we can't add focusListener to it, (yet at a later time it will gain focus)    
//FocusOwner (on edit): javax.swing.tree.DefaultTreeCellEditor$DefaultTextField
//editingComponent is by default a DefaultTextField                    
        }        

    @Override
    public Component getTreeCellEditorComponent(final JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row) {
       Component container = super.getTreeCellEditorComponent(tree, value, isSelected, expanded, leaf, row);
//Note: System.out.println("Components Type: "+containeractually.getClass().getName());
//was used to show it was container, javax.swing.tree.DefaultTreeCellEditor$EditorContainer

//getTreeCellEditorComponent(parameters) is called as soon as editing begins
//also at this time editingComponent != null (aka initialized)
//so it's a good place to add in a Focus Listener

editingComponent.addFocusListener( new FocusListener(){
                @Override  public void focusGained(FocusEvent e) { }
                @Override  public void focusLost(FocusEvent e) {
                tree.stopEditing();}                  } );

//EditorContainer is responsible for displaying the editingComponent
//so we added focusListener, after editingComponent initialized, and before it's used
//(I think the return statement means it's about to be used)
        return container;
        }
}//end MyTreeCellEditor

}//end class