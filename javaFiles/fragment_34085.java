package compiler;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class gui extends javax.swing.JFrame {

/**
 * Creates new form gui
 */
public gui() {
    initComponents();
    methodToReadFile();
}

...

private void methodToReadFile()
{
    try {

        FileInputStream fstream = new FileInputStream("c:\\test.txt");
        // Use DataInputStream to read binary NOT text.
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
        String strLine;
        // Read File Line By Line
        while ((strLine = br.readLine()) != null) {
            String a[] = strLine.split(" ");
             editArea.setText("Call Load");
            switch(a[0]) {
                case "LOAD":
                   // jTextArea1.setText("Call Load");
                    //System.out.println();
                    break;
                case "STORE":
                    System.out.println("Call Halt");
                    break;
                case "ADD":
                    System.out.println("Call Add");
                    break;
                case "SUBT":
                    System.out.println("Call Subt");
                    break;
                case "JUMP":
                    System.out.println("Call Jump");
                    break;
                case "MULT":
                    System.out.println("Call Mult");
                    break;
                case "ENTER":
                    System.out.println("Call Enter");
                    break;
                case "DISP":
                    System.out.println("Call Disp");
                    break;  
                case "END":
                    System.out.println("Call End");
                    break; 
                case "CHKR":
                    System.out.println("Call Chkr");
                    break;    
            }
        }
        in.close();
    } catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
    }
}

...

//the main
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(gui.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }


    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new gui().setVisible(true);
        }
    });
}