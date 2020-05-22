import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.TransferHandler;


public class TransferableJFrame {



    public static void main(String[] args) {
        JFrame f=new JFrame();

        f.setSize(1000, 1000);

        JPanel contentPane=new JPanel();
        contentPane.setOpaque(true);
        contentPane.setBackground(Color.red);
        contentPane.setLayout(new FlowLayout());

        contentPane.setTransferHandler(new MyTrasnferHandler());


        JPanel child=new JPanel();
        child.setOpaque(true);
        child.setBackground(Color.BLUE);
        child.setPreferredSize(new Dimension (600,600));
        contentPane.add(child);
        f.setContentPane(contentPane);

        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);


    }

    private static class MyTrasnferHandler extends TransferHandler{
        @Override
        public boolean canImport(JComponent comp, DataFlavor[] transferFlavors) {
            System.out.println("we will drop here");
            return true;
        }
        @Override
        public boolean importData(JComponent comp, Transferable t) {
            System.out.println("Dropped");
            return super.importData(comp, t);
        }
    }


}