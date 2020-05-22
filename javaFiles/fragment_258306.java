import javax.swing.JLabel;
import javax.swing.event.DocumentEvent.EventType;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;


public class MyDocument extends DefaultStyledDocument {

    public MyDocument(){
        BranchElement rootElement = (BranchElement) getDefaultRootElement();

        writeLock();

        LeafElement black10Element = (LeafElement) createLeafElement(rootElement, new SimpleAttributeSet(), 0, 1);
        JLabel black10 = new JLabel("10 ...");
        StyleConstants.setComponent(black10Element, black10);

        /////////////////// Added lines
        DefaultDocumentEvent documentEvent = this.new DefaultDocumentEvent(0, 1, EventType.INSERT);
        try {
            getContent().insertString(0, " ");
        } catch(BadLocationException e){
            e.printStackTrace();
        }
        insertUpdate(documentEvent, black10Element);
        documentEvent.end();
        fireInsertUpdate(documentEvent);
        /////////////////////////////////////

        writeUnlock();
    }


    private static final long serialVersionUID = -7424640574620960694L;

}