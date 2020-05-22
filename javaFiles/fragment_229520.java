package org.test;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class SwingSystemTray {

public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run () {
            try {
                /* We are going for the Windows Look and Feel here */
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                new SwingSystemTray ();
            } catch (Exception e) {
                System.out.println("Not using the System UI defeats the purpose...");
                e.printStackTrace();
            }
        }
    });
}

protected SystemTray systemTray;
protected TrayIcon trayIcon;
protected JPopupMenu systemTrayPopupMenu;
protected Image iconImage;
/* Added a "hidden dialog" */
protected JDialog hiddenDialog;

public SwingSystemTray () throws IOException {
    iconImage = getIcon ();
    if (SystemTray.isSupported()) {
        systemTray = SystemTray.getSystemTray();
        systemTrayPopupMenu = buildSystemTrayJPopupMenu();
        trayIcon = new TrayIcon(iconImage, "Application Name", null /* Popup Menu */);
        trayIcon.addMouseListener (new MouseAdapter () {
            @Override
            public void mouseReleased (MouseEvent me) {
                if (me.isPopupTrigger()) {
                    systemTrayPopupMenu.setLocation(me.getX(), me.getY());
                    /* Place the hidden dialog at the same location */
                    hiddenDialog.setLocation(me.getX(), me.getY());
                    /* Now the popup menu's invoker is the hidden dialog */
                    systemTrayPopupMenu.setInvoker(hiddenDialog);
                    hiddenDialog.setVisible(true);
                    systemTrayPopupMenu.setVisible(true);
                }
            }
        });
        trayIcon.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent ae) {
                System.out.println("actionPerformed");
            }
        });
        try {
            systemTray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("Could not place item at tray.  Exiting.");
        }
    }
    /* Initialize the hidden dialog as a headless, titleless dialog window */
    hiddenDialog = new JDialog ();
    hiddenDialog.setSize(10, 10);
    /* Add the window focus listener to the hidden dialog */
    hiddenDialog.addWindowFocusListener(new WindowFocusListener () {
        @Override
        public void windowLostFocus (WindowEvent we ) {
            hiddenDialog.setVisible(false);
        }
        @Override
        public void windowGainedFocus (WindowEvent we) {}
    });
}

protected JPopupMenu buildSystemTrayJPopupMenu () {
    final JPopupMenu menu = new JPopupMenu ();
    final JMenuItem showMenuItem = new JMenuItem("Show");
    final JMenuItem hideMenuItem = new JMenuItem("Hide");
    final JMenuItem exitMenuItem = new JMenuItem("Exit");
    hideMenuItem.setEnabled(false);
    ActionListener listener = new ActionListener () {
        @Override
        public void actionPerformed (ActionEvent ae) {
            /* We want to make sure the hidden dialog goes away after selection */
            hiddenDialog.setVisible(false);
            Object source = ae.getSource();
            if (source == showMenuItem) {
                System.out.println("Shown");
                showMenuItem.setEnabled(false);
                hideMenuItem.setEnabled(true);
            }
            else if (source == hideMenuItem) {
                System.out.println("Hidden");
                hideMenuItem.setEnabled(false);
                showMenuItem.setEnabled(true);
            }
            else if (source == exitMenuItem) {
                System.exit(0);
            }
        }
    };
    for (JMenuItem item : new JMenuItem [] {showMenuItem, hideMenuItem, exitMenuItem}) {
        if (item == exitMenuItem) menu.addSeparator();
        menu.add(item);
        item.addActionListener(listener);
    }
    return menu;
}

protected Image getIcon () throws IOException {
    // Build the 16x16 image programmatically, start with BMP Header
    byte [] iconData = new byte[822];
    System.arraycopy(new byte [] {0x42,0x4d,0x36,0x03, 0,0,0,0, 0,0,0x36,0, 
            0,0,0x28,0, 0,0,16,0, 0,0,16,0, 0,0,16,0, 24,0,0,0, 0,0,0,3},
            0, iconData, 0, 36);
    for (int i = 36; i < 822; iconData[i++] = 0);
    for (int i = 56; i < 822; i += 3) iconData[i] = -1;        
    return ImageIO.read(new java.io.ByteArrayInputStream(iconData));
}
}