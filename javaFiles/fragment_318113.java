import javax.swing.text.TextAction;
import javax.swing.Action;
import java.awt.event.ActionEvent;

public class IgnoreModifiedKeystrokesAction extends TextAction
{
    private static final int ignoredModifiersMask = 
        ActionEvent.CTRL_MASK | ActionEvent.ALT_MASK;
    private Action original;

    public IgnoreModifiedKeystrokesAction(Action act)
    {
        super((String)act.getValue("Name"));
        original = act;
    }

    public void actionPerformed(ActionEvent e)
    {
        if ((e.getModifiers() & ignoredModifiersMask) == 0) {
            /* Only dispatch the original action if no modifiers were used */
            original.actionPerformed(e);
        }
    }

    public Action getOriginalAction()
    {
        return original;
    }
}