package test;

import java.awt.BorderLayout;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class Test {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                String text = "<p><mt>Évangile selon Matthieu</mt>\n"
                        + "<c><cn>1</cn>\n"
                        + "<mt>Naissance et enfance de Jésus</mt><s>La généalogie de Jésus</s><r>(<ref v=\"LUK3.23-38\">Lc 3.23-38</ref>)</r><v><vn>1</vn>Voici la généalogie de Jésus-Christ, de la descendance de <g v=\"David\">David</g> et d'<g v=\"Abraham\">Abraham</g>. </v>"
                        + "<p/><v><q><vn>2 </vn>Abraham eut pour descendant <g v=\"Isaac\">Isaac</g>.<br/>Isaac eut pour descendant <g v=\"Jacob\">Jacob</g>.<br/>Jacob eut pour descendant <g v=\"Juda\">Juda</g> et ses frères.</q></v>"
                        + "<v><q><vn>3 </vn>De Thamar, Juda eut pour descendant Péretz et Zérah.<br/>Péretz eut pour descendant Hetsrom.<br/>Hetsrom eut pour descendant Aram.</q></v>"
                        + "<v><q><vn>4 </vn>Aram eut pour descendant Aminadab.<br/>Aminadab eut pour descendant Nahchôn,<br/>Nahchôn eut pour descendant Salma.</q></v>"
                        + "<v><q><vn>5 </vn>De Rahab, Salma eut pour descendant Booz.<br/>De Ruth, Booz eut pour descendant Obed.</q></v></c></p>";

                final JFrame mainFrame = new JFrame("test");
                mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                final JTextPane field = new JTextPane();
                field.setContentType("text/html");

                HTMLEditorKit kit = (HTMLEditorKit) field.getEditorKit();
                HTMLDocument doc = (HTMLDocument) field.getDocument();

                try (StringReader r = new StringReader(text)) {
                    kit.read(r, field.getDocument(), 0);
                } catch (IOException | BadLocationException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }

                field.setCaretPosition(10);
                field.setSelectionStart(doc.getCharacterElement(field.getCaretPosition()).getParentElement().getStartOffset());
                field.setSelectionEnd(doc.getCharacterElement(field.getCaretPosition()).getParentElement().getEndOffset());

                try (StringWriter w = new StringWriter()) {
                    kit.write(w, field.getDocument(), field.getSelectionStart(), field.getSelectionEnd()-field.getSelectionStart());
                    System.out.println(w.toString());
                } catch (IOException | BadLocationException ex) {
                    Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
                }

                mainFrame.getContentPane().setLayout(new BorderLayout());
                mainFrame.getContentPane().add(field,BorderLayout.CENTER);
                mainFrame.setSize(500,500);
                mainFrame.setVisible(true);
            }
        });
    }
}