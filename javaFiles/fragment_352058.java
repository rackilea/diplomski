import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListCellRenderer;
import javax.swing.SwingWorker;

public class LazyImageLoadingCellRendererTest
{

    private JPanel mainPanel = new JPanel();
    private JList<Product> list = new JList<Product>();
    private JScrollPane scroll = new JScrollPane();

    public LazyImageLoadingCellRendererTest()
    {
        mainPanel.setBackground(new Color(129, 133, 142));

        scroll.setViewportView(list);
        scroll.setHorizontalScrollBarPolicy(
            JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setPreferredSize(new Dimension(80, 200));

        list.setCellRenderer(new LazyImageLoadingCellRenderer<Product>(list,
            LazyImageLoadingCellRendererTest::loadAndProcessImage));
        DefaultListModel<Product> model = new DefaultListModel<Product>();

        for (int i=0; i<1000; i++)
        {
            model.addElement(new Product("id" + i));
        }
        list.setModel(model);

        mainPanel.add(scroll);
    }

    public static void main(String[] args) throws IOException
    {

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("WorkerTest");
                frame.setContentPane(
                    new LazyImageLoadingCellRendererTest().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLocation(300, 300);
                frame.setMinimumSize(new Dimension(160, 255));
                frame.setVisible(true);
            }
        });
    }

    private static final Random random = new Random(0);

    private static BufferedImage loadAndProcessImage(Product product)
    {
        String id = product.getProductID();
        int w = 100;
        int h = 20;
        BufferedImage image =
            new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.GREEN);
        g.fillRect(0, 0, w, h);
        g.setColor(Color.BLACK);
        g.drawString(id, 10, 16);
        g.dispose();

        long delay = 500 + random.nextInt(3000);
        try
        {
            System.out.println("Load time of " + delay + " ms for " + id);
            Thread.sleep(delay);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return image;
    }

    class Product
    {
        String productID;

        public Product(String productID)
        {
            this.productID = productID;
        }

        public String getProductID()
        {
            return productID;
        }
    }

}

class LazyImageLoadingCellRenderer<T> extends JLabel
    implements ListCellRenderer<T>
{
    private final JList<?> owner;
    private final Function<? super T, ? extends BufferedImage> imageLookup;
    private final Set<T> pendingImages;
    private final Map<T, BufferedImage> loadedImages;

    public LazyImageLoadingCellRenderer(JList<?> owner,
        Function<? super T, ? extends BufferedImage> imageLookup)
    {
        this.owner = Objects.requireNonNull(
            owner, "The owner may not be null");
        this.imageLookup = Objects.requireNonNull(imageLookup,
            "The imageLookup may not be null");
        this.loadedImages = new ConcurrentHashMap<T, BufferedImage>();
        this.pendingImages =
            Collections.newSetFromMap(new ConcurrentHashMap<T, Boolean>());
        setOpaque(false);
    }

    class ImageLoadingWorker extends SwingWorker<BufferedImage, Void>
    {
        private final T element;

        ImageLoadingWorker(T element)
        {
            this.element = element;
            pendingImages.add(element);
        }

        @Override
        protected BufferedImage doInBackground() throws Exception
        {
            try
            {
                BufferedImage image = imageLookup.apply(element);
                loadedImages.put(element, image);
                pendingImages.remove(element);
                return image;
            }
            catch (Exception e)
            {
                e.printStackTrace();
                return null;
            }
        }

        @Override
        protected void done()
        {
            owner.repaint();
        }
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends T> list,
        T value, int index, boolean isSelected, boolean cellHasFocus)
    {
        BufferedImage image = loadedImages.get(value);
        if (image == null)
        {
            if (!pendingImages.contains(value))
            {
                //System.out.println("Execute for " + value);
                ImageLoadingWorker worker = new ImageLoadingWorker(value);
                worker.execute();
            }
            setText("Loading...");
            setIcon(null);
        }
        else
        {
            setText(null);
            setIcon(new ImageIcon(image));
        }
        return this;
    }
}