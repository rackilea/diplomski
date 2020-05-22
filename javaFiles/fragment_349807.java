/**
 *
 * @author MaskedCoder
 */
package testwindowadapter;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class ReliableOneShotCloseListener extends WindowAdapter implements WindowListener {
    public interface CloseDuties {
        public boolean confirmClose(WindowEvent e);
        public void windowClosing(WindowEvent e);
    }

    private CloseDuties closeDuties;
    private int defaultCloseOperation;
    private boolean windowClosingFired = false;

    public ReliableOneShotCloseListener(int iniDefaultCloseOperation, CloseDuties iniCloseDuties) {
        super();
        closeDuties = iniCloseDuties;
        defaultCloseOperation = iniDefaultCloseOperation;
    }

    private int getDefaultCloseOperation(WindowEvent e) {
        if(e.getComponent() instanceof JFrame) {
            return ((JFrame) e.getComponent()).getDefaultCloseOperation();
        } 
        else if(e.getComponent() instanceof JDialog) {
            return ((JDialog) e.getComponent()).getDefaultCloseOperation();
        }
        else throw new IllegalArgumentException("WindowEvent.getComponent() is " + e.getComponent().getClass().getSimpleName() + ", must be JFrame or JDialog.");
    }

    private void setDefaultCloseOperation(WindowEvent e, int newDefaultCloseOperation) {
        if(e.getComponent() instanceof JFrame) {
            ((JFrame) e.getComponent()).setDefaultCloseOperation(newDefaultCloseOperation);
        } 
        else if(e.getComponent() instanceof JDialog) {
            ((JDialog) e.getComponent()).setDefaultCloseOperation(newDefaultCloseOperation);
        }
        else throw new IllegalArgumentException("WindowEvent.getComponent() is " + e.getComponent().getClass().getSimpleName() + ", must be JFrame or JDialog.");
    }

    private void performCloseDuties(WindowEvent e) {
        if(!windowClosingFired) {
            if(closeDuties.confirmClose(e)) {
                setDefaultCloseOperation(e, defaultCloseOperation);
                closeDuties.windowClosing(e);
                windowClosingFired = true;
            }
            else
                setDefaultCloseOperation(e, WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

    public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }

    public void setDefaultCloseOperation(int newDefaultCloseOperation) {
        defaultCloseOperation = newDefaultCloseOperation;
    }

    @Override
    public void windowOpened(WindowEvent e) {
        windowClosingFired = false;
    }

    @Override
    public void windowClosing(WindowEvent e) {
        performCloseDuties(e);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        performCloseDuties(e);
    }

    @Override
    public void windowActivated(WindowEvent e) {
        windowClosingFired = false;
    }

    @Override
    public void windowDeactivated(WindowEvent e) {      
        if(!e.getComponent().isVisible()) 
            performCloseDuties(e);
    }
}