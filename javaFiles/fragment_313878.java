package jfxtest;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.datatransfer.DataFlavor;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.DataFormat;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.TransferHandler;
import javax.swing.TransferHandler.TransferSupport;

public class MyApp {

  final static String MY_MIME_TYPE = "application/x-my-mime";
  public static final DataFormat FORMAT = new DataFormat(MY_MIME_TYPE);
  public static final DataFlavor FLAVOR = new DataFlavor(MY_MIME_TYPE, "My Mime Type");

  private void startDrag(Node node) {
    node.startDragAndDrop(TransferMode.COPY).setContent(
        // put a ByteBuffer to transfer the content unaffected
        Collections.singletonMap(FORMAT, StandardCharsets.UTF_8.encode("Test")));
  }

  private boolean processData(TransferSupport support) {
    try (InputStream in = (InputStream) support.getTransferable().getTransferData(FLAVOR)) {
      byte[] textBytes = new byte[in.available()];
      in.read(textBytes);
      String transferred = new String(textBytes, StandardCharsets.UTF_8); 
      System.out.println("transferred text: " + transferred);
      return true;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return false;
  }  

  public static void main(String[] args) {
    new MyApp().run();
  }

  private void run() {
    JFrame frame = new JFrame();
    frame.setLayout(new GridLayout(1, 2));
    frame.add(buildSwing());
    SwingUtilities.invokeLater(() -> {
      frame.add(buildFX());
    });
    frame.setSize(300, 300);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }

  private JFXPanel buildFX() {
    BorderPane parent = new BorderPane();
    parent.setOnDragDetected(event -> {
      startDrag(parent);
      event.consume();
    });
    JFXPanel panel = new JFXPanel();
    panel.setScene(new Scene(parent));
    return panel;
  }


  private JPanel buildSwing() {
    JPanel panel = new JPanel();
    panel.setBackground(Color.ORANGE);
    panel.setTransferHandler(new TransferHandler() {
      private static final long serialVersionUID = 1L;

      @Override
      public boolean canImport(TransferSupport support) {
        return support.isDataFlavorSupported(FLAVOR);
      }

      @Override
      public boolean importData(TransferSupport support) {
        if (canImport(support)) {
          return processData(support);
        }
        return false;
      }

    });
    return panel;
  }

}