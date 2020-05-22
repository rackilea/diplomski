import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class TestDragNDrop {

    public static void main(String[] args) {
        new TestDragNDrop();
    }

    public TestDragNDrop() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public static class TestPane extends JPanel implements DropTargetListener {

        public enum DragState {

            Waiting,
            Accept,
            Reject
        }
        private DragState state = DragState.Waiting;
        private BufferedImage happy;
        private BufferedImage wait;
        private BufferedImage sad;

        public TestPane() {
            DropTarget dt = new DropTarget(
                    this,
                    DnDConstants.ACTION_COPY_OR_MOVE,
                    this,
                    true);

            setBackground(Color.BLACK);
            try {
                happy = ImageIO.read(getClass().getResource("/Happy.png"));
                wait = ImageIO.read(getClass().getResource("/Wait.png"));
                sad = ImageIO.read(getClass().getResource("/Sad.png"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(300, 300);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            BufferedImage bg = null;
            switch (state) {
                case Waiting:
                    bg = wait;
                    break;
                case Accept:
                    bg = happy;
                    break;
                case Reject:
                    bg = sad;
                    break;
            }
            if (bg != null) {
                int x = (getWidth() - bg.getWidth()) / 2;
                int y = (getHeight() - bg.getHeight()) / 2;
                g.drawImage(bg, x, y, this);
            }
        }

        @Override
        public void dragEnter(DropTargetDragEvent dtde) {
            state = DragState.Reject;
            Transferable t = dtde.getTransferable();
            if (t.isDataFlavorSupported(DataFlavor.javaFileListFlavor)) {
                try {
                    Object td = t.getTransferData(DataFlavor.javaFileListFlavor);
                    if (td instanceof List) {
                        state = DragState.Accept;
                        for (Object value : ((List) td)) {
                            if (value instanceof File) {
                                File file = (File) value;
                                String name = file.getName().toLowerCase();
                                if (!name.endsWith(".png")) {
                                    state = DragState.Reject;
                                    break;
                                }
                            }
                        }
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
            if (state == DragState.Accept) {
                dtde.acceptDrag(DnDConstants.ACTION_COPY);
            } else {
                dtde.rejectDrag();
            }
            repaint();
        }

        @Override
        public void dragOver(DropTargetDragEvent dtde) {
        }

        @Override
        public void dropActionChanged(DropTargetDragEvent dtde) {
        }

        @Override
        public void dragExit(DropTargetEvent dte) {
            state = DragState.Waiting;
            repaint();
        }

        @Override
        public void drop(DropTargetDropEvent dtde) {
            state = DragState.Waiting;
            repaint();
        }
    }
}