// @author Santhosh Kumar T - santhosh@in.fiorano.com 
public class MyEventQueue extends EventQueue{ 
    protected void dispatchEvent(AWTEvent event){ 
        super.dispatchEvent(event); 

        // interested only in mouseevents 
        if(!(event instanceof MouseEvent)) 
            return; 

        MouseEvent me = (MouseEvent)event; 

        // interested only in popuptriggers 
        if(!me.isPopupTrigger()) 
            return; 

        // me.getComponent(...) retunrs the heavy weight component on which event occured 
        Component comp = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY()); 

        // interested only in textcomponents 
        if(!(comp instanceof JTextComponent)) 
            return; 

        // no popup shown by user code 
        if(MenuSelectionManager.defaultManager().getSelectedPath().length>0) 
            return; 

        // create popup menu and show 
        JTextComponent tc = (JTextComponent)comp; 
        JPopupMenu menu = new JPopupMenu(); 
        menu.add(new CutAction(tc)); 
        menu.add(new CopyAction(tc)); 
        menu.add(new PasteAction(tc)); 
        menu.add(new DeleteAction(tc)); 
        menu.addSeparator(); 
        menu.add(new SelectAllAction(tc)); 

        Point pt = SwingUtilities.convertPoint(me.getComponent(), me.getPoint(), tc);
        menu.show(tc, pt.x, pt.y);
    } 
}