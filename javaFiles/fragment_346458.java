// File ExtractSelectionFromPdf.java

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.*;

import java.awt.Container;
import java.awt.Point;
import java.io.IOException;
import javax.swing.*;

public class ExtractSelectionFromPdf {
    private static String filePath = "[file path to a pdf file]";

    private PdfViewer pdfViewer;

    public static void main(final String[] arguments) {
        SwingUtilities.invokeLater(() -> new ExtractSelectionFromPdf().launchGUI());
    }

    private void launchGUI() {
        final JFrame frame = new JFrame("Extract selected text from a pdf");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        final Container contentPane = frame.getContentPane();

        pdfViewer = new PdfViewer();
        contentPane.add(pdfViewer);

        pdfViewer.openDocument(filePath);

        final CustomGlassPane customGlassPane = new CustomGlassPane(this, contentPane);
        frame.setGlassPane(customGlassPane);
        customGlassPane.setVisible(true);

        frame.setBounds(60, 10, 1800, 1000);
        frame.setVisible(true);
    }

    public void handleSelection(final Point topLeft, final Point bottomRight) {
        final int width = bottomRight.x - topLeft.x;
        final int height = bottomRight.y - topLeft.x;
        final String text = parsePdf(topLeft.x, topLeft.y, width, height, filePath);
        System.out.println("text: " + text);
    }

    public String parsePdf(final int x, final int y, final int width, final int height, 
                           final String pdfFilePath) {
        String text = null;

        try {
            final PdfReader pdfReader = new PdfReader(pdfFilePath);
            final int pageNumber = pdfViewer.getCurrentPageNumber() + 1;
            System.out.println("Page number: " + pageNumber);
            final Rectangle selection = new Rectangle(x, y, width, height);
            final RenderFilter renderFilter = new RegionTextRenderFilter(selection);
            final LocationTextExtractionStrategy delegate 
                    = new LocationTextExtractionStrategy();
            final TextExtractionStrategy extractionStrategy 
                    = new FilteredTextRenderListener(delegate, renderFilter);
            text = PdfTextExtractor.getTextFromPage(pdfReader, pageNumber, 
                                                    extractionStrategy);
            pdfReader.close();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return text;
    }
}


// File PdfViewer.java

import java.util.ResourceBundle;
import javax.swing.*;
import org.icepdf.ri.common.*;
import org.icepdf.ri.common.views.DocumentViewController;
import org.icepdf.ri.util.PropertiesManager;

public class PdfViewer extends JPanel {
    private final SwingController controller;

    public PdfViewer() {
        controller = new SwingController();
        controller.setIsEmbeddedComponent(true);

        final String bundleName = PropertiesManager.DEFAULT_MESSAGE_BUNDLE;
        final ResourceBundle messageBundle = ResourceBundle.getBundle(bundleName);
        final Properties systemProperties = System.getProperties();
        final PropertiesManager properties = new PropertiesManager(systemProperties,
                                                                   messageBundle);

        properties.set(PropertiesManager.PROPERTY_DEFAULT_ZOOM_LEVEL, "1");

        final SwingViewBuilder factory = new SwingViewBuilder(controller, properties);

        final DocumentViewController viewController 
                = controller.getDocumentViewController();
        viewController.setAnnotationCallback(new MyAnnotationCallback(viewController));

        final JScrollPane scrollPane = new JScrollPane(factory.buildViewerPanel());
        final int horizontalPolicy = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS;
        final int verticalPolicy = ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS;
        scrollPane.setHorizontalScrollBarPolicy(horizontalPolicy);
        scrollPane.setVerticalScrollBarPolicy(verticalPolicy);
        add(scrollPane);
    }

    public void openDocument(final String filePath) {
        controller.openDocument(filePath);
    }

    public int getCurrentPageNumber() {
        return controller.getCurrentPageNumber();
    }
}


// File CustomGlassPane.java

import java.awt.*;
import javax.swing.JComponent;

public class CustomGlassPane extends JComponent {
    private Point topLeftPoint;
    private Point bottomRightPoint;

    public CustomGlassPane(final ExtractSelectionFromPdf extractSelectionFromPdf, 
                           final Container contentPane) {
        final MouseEventsListener listener 
                = new MouseEventsListener(extractSelectionFromPdf, this, contentPane);
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    public void setSelection(final Point topLeftPoint, final Point bottomRightPoint) {
        this.topLeftPoint = topLeftPoint;
        this.bottomRightPoint = bottomRightPoint;
    }

    protected void paintComponent(final Graphics graphics) {
        if (topLeftPoint != null && bottomRightPoint != null) {
            graphics.setColor(Color.BLACK);
            graphics.drawRect(topLeftPoint.x, 
                              topLeftPoint.y,
                              bottomRightPoint.x - topLeftPoint.x, 
                              bottomRightPoint.y - topLeftPoint.y);
        }
    }
}


// File MouseEventsListener.java

import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;
import javax.swing.event.MouseInputAdapter;

public class MouseEventsListener extends MouseInputAdapter {
    private ExtractSelectionFromPdf extractSelectionFromPdf;
    private CustomGlassPane customGlassPane;
    private Container contentPane;
    private Point topLeftPoint;
    private Point bottomRightPoint;

    public MouseEventsListener(final ExtractSelectionFromPdf extractSelectionFromPdf,
                               final CustomGlassPane customGlassPane,
                               final Container contentPane) {
        this.extractSelectionFromPdf = extractSelectionFromPdf;
        this.customGlassPane = customGlassPane;
        this.contentPane = contentPane;
    }

    public void mousePressed(final MouseEvent mouseEvent) {
        topLeftPoint = mouseEvent.getPoint();

        redispatchMouseEvent(mouseEvent);
    }

    public void mouseDragged(final MouseEvent mouseEvent) {
        bottomRightPoint = mouseEvent.getPoint();

        redispatchMouseEvent(mouseEvent, topLeftPoint != null, false);
    }

    public void mouseReleased(final MouseEvent mouseEvent) {
        bottomRightPoint = mouseEvent.getPoint();

        redispatchMouseEvent(mouseEvent, true, true);
    }

    public void mouseMoved(final MouseEvent mouseEvent) {
        redispatchMouseEvent(mouseEvent);
    }

    public void mouseClicked(final MouseEvent mouseEvent) {
        redispatchMouseEvent(mouseEvent);
    }

    public void mouseEntered(final MouseEvent mouseEvent) {
        redispatchMouseEvent(mouseEvent);
    }

    public void mouseExited(final MouseEvent mouseEvent) {
        redispatchMouseEvent(mouseEvent);
    }

    private void redispatchMouseEvent(final MouseEvent mouseEvent) {
        redispatchMouseEvent(mouseEvent, false, false);
    }

    private void redispatchMouseEvent(final MouseEvent mouseEvent, 
                                      final boolean repaint,
                                      final boolean extract) {
        final Point glassPanePoint = mouseEvent.getPoint();
        final Point containerPoint = SwingUtilities.convertPoint(customGlassPane, 
                                                                 glassPanePoint, 
                                                                 contentPane);

        if (containerPoint.y >= 0) {
            final Component component
                    = SwingUtilities.getDeepestComponentAt(contentPane,
                                                           containerPoint.x,
                                                           containerPoint.y);

            if (component != null) {
                final Point componentPoint 
                        = SwingUtilities.convertPoint(customGlassPane, 
                                                      glassPanePoint,
                                                      component);

                // Forward events to the component under the glass pane.
                component.dispatchEvent(new MouseEvent(component,
                                                       mouseEvent.getID(),
                                                       mouseEvent.getWhen(),
                                                       mouseEvent.getModifiers(),
                                                       componentPoint.x,
                                                       componentPoint.y,
                                                       mouseEvent.getClickCount(),
                                                       mouseEvent.isPopupTrigger()));
            }
        }

        // Update the glass pane if requested.
        if (repaint) {
            if (extract) {
                extractSelectionFromPdf.handleSelection(topLeftPoint, bottomRightPoint);

                topLeftPoint = null;
                bottomRightPoint = null;
            }

            customGlassPane.setSelection(topLeftPoint, bottomRightPoint);
            customGlassPane.repaint();
        }
    }
}