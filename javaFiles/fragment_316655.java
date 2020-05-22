import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DragGestureEvent;
import java.awt.dnd.DragGestureListener;
import java.awt.dnd.DragGestureRecognizer;
import java.awt.dnd.DragSource;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceDropEvent;
import java.awt.dnd.DragSourceEvent;
import java.awt.dnd.DragSourceListener;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class TestDnD {

    public static void main(String[] args) {
        new TestDnD();
    }

    public TestDnD() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (ClassNotFoundException ex) {
                    } catch (InstantiationException ex) {
                    } catch (IllegalAccessException ex) {
                    } catch (UnsupportedLookAndFeelException ex) {
                    }

                    JFrame frame = new JFrame("Test");
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame.setLayout(new GridLayout(0, 2, 10, 10));
                    ((JComponent) frame.getContentPane()).setBorder(new EmptyBorder(10, 10, 10, 10));

                    BufferedImage img = ImageIO.read(new File("issue376.jpg"));
                    ImagePane imagePane = new ImagePane();
                    imagePane.addImage(img);

                    frame.add(imagePane);
                    frame.add(new ImagePane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.exit(0);
                }
            }

        });
    }

    public class ImagePane extends JPanel {

        private List<DragImage> images;
        private DragImages dropImages;
        private Point dragPoint;

        public ImagePane() {
            setBorder(new LineBorder(Color.GRAY));
            images = new ArrayList<>(25);

            DragGestureRecognizer dgr = DragSource.getDefaultDragSource().createDefaultDragGestureRecognizer(
                            this,
                            DnDConstants.ACTION_COPY_OR_MOVE,
                            new DragGestureHandler(this));

            DropTarget dt = new DropTarget(
                            this,
                            DnDConstants.ACTION_COPY_OR_MOVE,
                            new DropTargetHandler(this),
                            true);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        public DragImage getImageAt(Point p) {
            DragImage at = null;
            for (DragImage di : images) {
                if (di.contains(p)) {
                    at = di;
                    break;
                }
            }
            return at;
        }

        protected boolean contains(Image image) {
            boolean contains = false;
            for (DragImage di : images) {
                if (di.getImage() == image) {
                    contains = true;
                    break;
                }
            }
            return contains;
        }

        public void addImage(Image image) {
            if (image != null) {
                if (!contains(image)) {
                    int x = (int) Math.round(Math.random() * getWidth());
                    int y = (int) Math.round(Math.random() * getHeight());
                    addImageAt(new Point(x, y), image);
                }
            }
        }

        public void addImageAt(Point p, Image image) {
            if (p != null && image != null) {
                if (!contains(image)) {
                    DragImage di = new DragImage(image, p);
                    images.add(di);
                    repaint();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            for (DragImage di : images) {
                g2d.drawImage(di.getImage(), di.getLocation().x, di.getLocation().y, this);
            }
            if (dropImages != null) {
                g2d.setComposite(AlphaComposite.SrcOver.derive(0.5f));
                Point offset = dropImages.getOffset();
                for (DragImage di : dropImages.getImages()) {
                    Point pp = new Point(dragPoint);
                    pp.x -= offset.getX();
                    pp.y -= offset.getY();
                    g2d.drawImage(di.getImage(), pp.x, pp.y, this);
                }
            }
            g2d.dispose();
        }

        public void removeImages(List list) {
            if (list != null && list.size() > 0) {
                for (Object obj : list) {
                    if (obj instanceof DragImage) {
                        removeImage((DragImage) obj);
                    }
                }
            }
        }

        public void removeImage(DragImage img) {
            images.remove(img);
            repaint();
        }

        protected void setDragImages(DragImages dragImages) {
            this.dropImages = dragImages;
            repaint();
        }

        public void addImagesAt(Point location, List images) {
            if (images != null && images.size() > 0) {
                for (Object obj : images) {
                    if (obj instanceof Image) {
                        Image img = (Image) obj;
                        addImageAt(location, img);
                        location.x += 10;
                        location.y += 10;
                        if (location.x >= getWidth()) {
                            location.x = 0;
                        }
                        if (location.y >= getHeight()) {
                            location.y = 0;
                        }
                    }
                }
            }
        }

        protected void addImages(DragImages dragImages) {
            for (DragImage di : dragImages.getImages()) {
                images.add(di);
            }
            repaint();
        }

        protected void addImagesAt(Point dropPoint, DragImages dragImages) {
            Point offset = dragImages.getOffset();
            for (DragImage di : dragImages.getImages()) {
                Point p = di.getLocation();
                p.x = dropPoint.x - offset.x;
                p.y = dropPoint.y - offset.y;
                images.add(di);
            }
            repaint();
        }

        protected void setDragPoint(Point location) {
            dragPoint = location;
            repaint();
        }

    }

    public static class ImageTransferable implements Transferable {

        public static final DataFlavor DRAG_IMAGE_DATA_FLAVOR = new DataFlavor(List.class, "Images");
        private DragImages dragImages;

        public ImageTransferable(DragImages dragImages) {
            this.dragImages = dragImages;
        }

        @Override
        public DataFlavor[] getTransferDataFlavors() {
            return new DataFlavor[]{DRAG_IMAGE_DATA_FLAVOR};
        }

        @Override
        public boolean isDataFlavorSupported(DataFlavor flavor) {
            return DRAG_IMAGE_DATA_FLAVOR.equals(flavor);
        }

        @Override
        public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
            return dragImages;
        }

    }

    public class DragImage {

        private Image image;
        private Point p;

        public DragImage(Image image, Point p) {
            this.image = image;
            this.p = p;
        }

        public Image getImage() {
            return image;
        }

        public Point getLocation() {
            return p;
        }

        public Dimension getSize() {
            return new Dimension(image.getWidth(null), image.getHeight(null));
        }

        public boolean contains(Point p) {
            return new Rectangle(getLocation(), getSize()).contains(p);
        }

    }

    public class DragImages {

        private Point offset;
        private List<DragImage> images;

        public DragImages(Point offset, DragImage... images) {
            this.offset = offset;
            this.images = Arrays.asList(images);
        }

        public Point getOffset() {
            return offset;
        }

        public List<DragImage> getImages() {
            return images;
        }

    }

    protected class DragGestureHandler implements DragGestureListener {

        private ImagePane imagePane;

        public DragGestureHandler(ImagePane list) {
            this.imagePane = list;
        }

        @Override
        public void dragGestureRecognized(DragGestureEvent dge) {
            DragImage di = imagePane.getImageAt(dge.getDragOrigin());
            if (di != null) {
                Point origin = dge.getDragOrigin();
                Point p = new Point();
                p.x = origin.x - di.getLocation().x;
                p.y = origin.y - di.getLocation().y;
                Transferable t = new ImageTransferable(new DragImages(p, di));
                imagePane.removeImage(di);
                DragSource ds = dge.getDragSource();
                ds.startDrag(
                                dge,
                                null,
                                t,
                                new DragSourceHandler(imagePane));
            }

        }

    }

    protected class DragSourceHandler implements DragSourceListener {

        private ImagePane pane;

        public DragSourceHandler(ImagePane pane) {
            this.pane = pane;
        }

        public void dragEnter(DragSourceDragEvent dsde) {
        }

        public void dragOver(DragSourceDragEvent dsde) {
            pane.repaint();
        }

        public void dropActionChanged(DragSourceDragEvent dsde) {
        }

        public void dragExit(DragSourceEvent dse) {
        }

        public void dragDropEnd(DragSourceDropEvent dsde) {
            if (!dsde.getDropSuccess()) {
                Transferable t = dsde.getDragSourceContext().getTransferable();
                if (t != null) {
                    try {
                        Object transferData = t.getTransferData(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR);
                        if (transferData instanceof DragImages) {
                            DragImages di = (DragImages) transferData;
                            pane.addImages(di);
                        }
                    } catch (UnsupportedFlavorException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        }

    }

    protected class DropTargetHandler implements DropTargetListener {

        private ImagePane panel;

        public DropTargetHandler(ImagePane panel) {
            this.panel = panel;
        }

        public void dragEnter(DropTargetDragEvent dtde) {
            if (dtde.getTransferable().isDataFlavorSupported(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR)) {
                dtde.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
                updateDragImages(dtde);
            } else {
                dtde.rejectDrag();
            }
        }

        public void dragOver(DropTargetDragEvent dtde) {
            updateDragImages(dtde);
            panel.repaint();
        }

        public void dropActionChanged(DropTargetDragEvent dtde) {
        }

        public void dragExit(DropTargetEvent dte) {
            panel.setDragImages(null);
        }

        public void drop(DropTargetDropEvent dtde) {
            panel.setDragImages(null);
            if (dtde.getTransferable().isDataFlavorSupported(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR)) {
                Transferable t = dtde.getTransferable();
                if (t.isDataFlavorSupported(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR)) {
                    try {
                        Object transferData = t.getTransferData(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR);
                        if (transferData instanceof DragImages) {
                            DragImages images = (DragImages) transferData;
                            dtde.dropComplete(true);
                            dtde.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
                            panel.addImagesAt(dtde.getLocation(), images);
                        } else {
                            dtde.rejectDrop();
                        }
                    } catch (UnsupportedFlavorException ex) {
                        ex.printStackTrace();
                        dtde.rejectDrop();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                        dtde.rejectDrop();
                    }
                } else {
                    dtde.rejectDrop();
                }
            }
        }

        protected void updateDragImages(DropTargetDragEvent dtde) {
            panel.setDragImages(null);
            Transferable t = dtde.getTransferable();
            if (t != null) {
                try {
                    Object transferData = t.getTransferData(ImageTransferable.DRAG_IMAGE_DATA_FLAVOR);
                    if (transferData instanceof DragImages) {
                        panel.setDragPoint(dtde.getLocation());
                        panel.setDragImages((DragImages)transferData);
                    }
                } catch (UnsupportedFlavorException | IOException ex) {
                    ex.printStackTrace();
                }
            }
        }

    }
}