import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.SizeRequirements;
import javax.swing.border.TitledBorder;
import javax.swing.text.*;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.InlineView;
import javax.swing.text.html.StyleSheet;

@SuppressWarnings("serial")
public class LineWrapTest extends JFrame implements ActionListener, KeyListener {

    //This is the separator.
    private String SEPARATOR = System.getProperty("line.separator");
    private JButton btnSend;
    private JTextArea textAreaIn;
    private JEditorPane textAreaOut;
    private JScrollPane outputScrollPane;
    private HTMLEditorKit kit;
    private HTMLDocument doc;


    public LineWrapTest() {

        this.setSize(600, 500);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Linewrap Test");
    }

    /**
     * Not important for problem
     */
    public void paintScreen() {

        this.setLayout(new BorderLayout());

        this.add(this.getPanelOut(), BorderLayout.CENTER);
        this.add(this.getPanelIn(), BorderLayout.SOUTH);

        this.textAreaIn.requestFocusInWindow();
        this.setVisible(true);
    }


    /**
     * Not important for problem
     * 
     * @return panelOut
     */
    private JPanel getPanelOut() {

        JPanel panelOut = new JPanel();
        panelOut.setLayout(new BorderLayout());

        this.textAreaOut = new JEditorPane();
        this.textAreaOut.setEditable(false);
        this.textAreaOut.setContentType("text/html");

        //I added this scroll pane.
        this.outputScrollPane = new JScrollPane(this.textAreaOut);

        /*
         * This is a whole whack of code.  It's a combination of two sources.
         * It achieves the wrapping you desire: by word and longgg strings
         * It is a custom addition to HTMLEditorKit
         */
        this.kit = new HTMLEditorKit(){
           @Override 
           public ViewFactory getViewFactory(){ 

               return new HTMLFactory(){ 
                   public View create(Element e){ 
                      View v = super.create(e); 
                      if(v instanceof InlineView){ 
                          return new InlineView(e){ 
                              public int getBreakWeight(int axis, float pos, float len) { 
                                  //return GoodBreakWeight;
                                  if (axis == View.X_AXIS) {
                                      checkPainter();
                                      int p0 = getStartOffset();
                                      int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len);
                                      if (p1 == p0) {
                                          // can't even fit a single character
                                          return View.BadBreakWeight;
                                      }
                                      try {
                                          //if the view contains line break char return forced break
                                          if (getDocument().getText(p0, p1 - p0).indexOf(SEPARATOR) >= 0) {
                                              return View.ForcedBreakWeight;
                                          }
                                      }
                                      catch (BadLocationException ex) {
                                          //should never happen
                                      }  

                                  }
                                  return super.getBreakWeight(axis, pos, len);
                              } 
                              public View breakView(int axis, int p0, float pos, float len) { 
                                  if (axis == View.X_AXIS) {
                                      checkPainter();
                                      int p1 = getGlyphPainter().getBoundedPosition(this, p0, pos, len);
                                      try {
                                          //if the view contains line break char break the view
                                          int index = getDocument().getText(p0, p1 - p0).indexOf(SEPARATOR);
                                          if (index >= 0) {
                                              GlyphView v = (GlyphView) createFragment(p0, p0 + index + 1);
                                              return v;
                                          }
                                      }
                                      catch (BadLocationException ex) {
                                          //should never happen
                                      }

                                  }
                                  return super.breakView(axis, p0, pos, len);
                            } 
                          }; 
                      } 
                      else if (v instanceof ParagraphView) { 
                          return new ParagraphView(e) { 
                              protected SizeRequirements calculateMinorAxisRequirements(int axis, SizeRequirements r) { 
                                  if (r == null) { 
                                        r = new SizeRequirements(); 
                                  } 
                                  float pref = layoutPool.getPreferredSpan(axis); 
                                  float min = layoutPool.getMinimumSpan(axis); 
                                  // Don't include insets, Box.getXXXSpan will include them. 
                                    r.minimum = (int)min; 
                                    r.preferred = Math.max(r.minimum, (int) pref); 
                                    r.maximum = Integer.MAX_VALUE; 
                                    r.alignment = 0.5f; 
                                  return r; 
                                } 

                            }; 
                        } 
                      return v; 
                    } 
                }; 
            } 
        }; 

        this.doc = new HTMLDocument();

        StyleSheet styleSheet = this.kit.getStyleSheet();
        this.kit.setStyleSheet(styleSheet);

        this.textAreaOut.setEditorKit(this.kit);
        this.textAreaOut.setDocument(this.doc);

        TitledBorder border = BorderFactory.createTitledBorder("Output");
        border.setTitleJustification(TitledBorder.CENTER);

        panelOut.setBorder(border);

        //I changed this to add the scrollpane, which now contains
        //the JEditorPane
        panelOut.add(this.outputScrollPane);

        return panelOut;
    }

    /**
     * Not important for problem
     * 
     * @return panelIn
     */
    private JPanel getPanelIn() {

        JPanel panelIn = new JPanel();
        panelIn.setLayout(new BorderLayout());

        this.textAreaIn = new JTextArea();
        this.textAreaIn.setLineWrap(true);
        this.textAreaIn.setWrapStyleWord(true);

        //This disables enter from going to a new line.  Your key listener does that.
        this.textAreaIn.getInputMap().put(KeyStroke.getKeyStroke("ENTER"), "none");
        //For the key listener to work, it needs to be added to the component
        this.textAreaIn.addKeyListener(this);

        TitledBorder border = BorderFactory.createTitledBorder("Input");
        border.setTitleJustification(TitledBorder.CENTER);

        panelIn.setBorder(border);
        panelIn.add(this.getBtnSend(), BorderLayout.EAST);
        panelIn.add(this.textAreaIn, BorderLayout.CENTER);

        return panelIn;
    }

    /**
     * Not important for problem
     * 
     * @return btnSend
     */
    private JButton getBtnSend() {

        this.btnSend = new JButton("Send");
        this.btnSend.addActionListener(this);

        return this.btnSend;
    }


    private void append(String text) {

        try {
            this.kit.insertHTML(this.doc, this.doc.getLength(), text, 0, 0, null);
        } catch (BadLocationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getHTMLText() {
        //I tried to find a work around for this but I couldn't.  It could be done
        //by manipulating the HTMLDocument but it's beyond me.  Notice I changed
        //<br/> to <p/>.  For some reason, <br/> no longer went to the next line
        //when I added the custom wrap.  <p/> seems to work though.
        String txtIn = this.textAreaIn.getText().trim().replaceAll(SEPARATOR, "<p/>");

        //My IDE recommends you use StringBuilder instead, that's up to you.
        //I am not sure what the difference would be.
        StringBuffer htmlBuilder = new StringBuffer();

        htmlBuilder.append("<HTML>");
        htmlBuilder.append(txtIn);
        htmlBuilder.append("</HTML>");

        return htmlBuilder.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == this.btnSend) {
            this.append(this.getHTMLText());
            this.textAreaIn.setText("");
            this.textAreaIn.requestFocusInWindow();
        }
    }

    public static void main(String[] args) {
        LineWrapTest test = new LineWrapTest();
        test.paintScreen();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER){
            if (!this.textAreaIn.getText().trim().isEmpty()) {
                //I made this work by defining the SEPARATOR.
                //You could use append(Separator) instead if you want.
                this.textAreaIn.setText(this.textAreaIn.getText() + SEPARATOR);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}