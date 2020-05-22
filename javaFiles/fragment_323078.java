package com.protocase.utils.dialogs;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class BusyDlg extends JDialog {

    private Runnable r;

    public BusyDlg (String Message, Runnable r) {
    super();
        this.r = r;
    this.setModal(true);

        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        this.setLayout(new BorderLayout());

    this.getContentPane().add(new JLabel(Message));

        this.addWindowListener(new WindowAdapter() {

            @Override
            public void windowOpened(WindowEvent e) {
                super.windowOpened(e);
                // do something
                doBusy();
            }
        });




    this.pack();
    }

    public void Show() {
    this.setVisible(true);
    }

    public void doBusy() {
        this.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
        r.run();
        this.setCursor(Cursor.getDefaultCursor());
    this.setVisible(false);
        this.dispose();
    }
}