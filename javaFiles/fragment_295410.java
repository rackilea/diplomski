import java.awt.BorderLayout;
 import java.awt.Dimension;
 import java.awt.EventQueue;
 import java.awt.Graphics;
 import java.awt.Graphics2D;
 import java.io.File;
 import java.io.IOException;
 import javax.imageio.ImageIO;
 import javax.swing.JFrame;
 import javax.swing.JPanel;
 import javax.swing.JScrollPane;
 import javax.swing.JSlider;
 import javax.swing.UIManager;
 import javax.swing.UnsupportedLookAndFeelException;

 public class TestZoom100 {

      public static void main(String[] args) {
           new TestZoom100();
      }

      public TestZoom100() {
           EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                     try {
                          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                     } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                          ex.printStackTrace();
                     }

                     UIManager.getDefaults().put("ZoomComponentUI", "your.awesome.package.name.BasicZoomUI");

                     try {
                          DefaultZoomModel model = new DefaultZoomModel(ImageIO.read(new File("/your/awesome/image.jpg")));
                          model.setValue(50);
                          ZoomComponent zoomComp = new ZoomComponent();
                          zoomComp.setModel(model);

                          JSlider slider = new JSlider(model);

                          JFrame frame = new JFrame("Testing");
                          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                          frame.add(new JScrollPane(zoomComp));
                          frame.add(slider, BorderLayout.SOUTH);
                          frame.pack();
                          frame.setLocationRelativeTo(null);
                          frame.setVisible(true);
                     } catch (IOException exp) {
                          exp.printStackTrace();
                     }
                }
           });
      }

 }