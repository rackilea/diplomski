import javax.swing.*;

aspect EdtRuleChecker {
    private boolean isStressChecking = true;

    public pointcut anySwingMethods(JComponent c):
         target(c) && call(* *(..));

    public pointcut threadSafeMethods():         
         call(* repaint(..)) || 
         call(* revalidate()) ||
         call(* invalidate()) ||
         call(* getListeners(..)) ||
         call(* add*Listener(..)) ||
         call(* remove*Listener(..));

    //calls of any JComponent method, including subclasses
    before(JComponent c): anySwingMethods(c) && 
                          !threadSafeMethods() &&
                          !within(EdtRuleChecker) {
     if(!SwingUtilities.isEventDispatchThread() &&
         (isStressChecking || c.isShowing())) 
     {
             System.err.println(thisJoinPoint.getSourceLocation());
             System.err.println(thisJoinPoint.getSignature());
             System.err.println();
      }
    }

    //calls of any JComponent constructor, including subclasses
    before(): call(JComponent+.new(..)) {
      if (isStressChecking && !SwingUtilities.isEventDispatchThread()) {
          System.err.println(thisJoinPoint.getSourceLocation());
          System.err.println(thisJoinPoint.getSignature() +
                                " *constructor*");
          System.err.println();
      }
    }
}