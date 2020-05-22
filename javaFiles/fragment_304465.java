import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.ArrayList;

import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import javax.swing.text.Element;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.rtf.RTFEditorKit;

public class RTFReader {

public static void main(String[] args) {
    File input1 = new File("C:\\ragu\\input1.rtf");
    File input2 = new File("C:\\ragu\\input2.rtf");
    File output = new File ("C:\\ragu\\output.rtf");

    FileInputStream fis1 = null;
    FileInputStream fis2 = null;
    FileOutputStream fw = null;
    try {
        fis1 = new FileInputStream(input1);
        fis2 = new FileInputStream(input2);
        fw = new FileOutputStream(output);
    } catch (IOException e1) {
        e1.printStackTrace();
    }


    try {
        Document doc1 = load(fis1);
        Document doc2 = load(fis2);
        //String contents1 = doc1.getText(0, doc1.getLength());
        //String contents2 = doc2.getText(0, doc2.getLength());
        mergeDocument((DefaultStyledDocument)doc2, (DefaultStyledDocument)doc1);
        RTFEditorKit rtf = new RTFEditorKit();
        rtf.write(fw, doc1, 0, doc1.getLength());
        //System.out.println(contents1+contents2);
    } catch (IOException e) {
        e.printStackTrace();
    } catch (BadLocationException e) {
        e.printStackTrace();
    }
    finally{
        try {
            fis1.close();
            fis2.close();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public static Document load(InputStream is) throws IOException {
    RTFEditorKit rtf = new RTFEditorKit();
    Document doc = rtf.createDefaultDocument();
    BufferedReader input = new BufferedReader(new InputStreamReader(is));
    try {
        rtf.read(input, doc, 0);
    } catch (BadLocationException ble) {
        throw new IOException(ble);
    }
    return doc;
}

public static void mergeDocument(DefaultStyledDocument source, DefaultStyledDocument dest) throws BadLocationException {
    ArrayList<DefaultStyledDocument.ElementSpec> specs=new ArrayList<DefaultStyledDocument.ElementSpec>();
    DefaultStyledDocument.ElementSpec spec=new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), 
             DefaultStyledDocument.ElementSpec.EndTagType);
    specs.add(spec);
    fillSpecs(source.getDefaultRootElement(), specs, false);
    spec=new DefaultStyledDocument.ElementSpec(new SimpleAttributeSet(), DefaultStyledDocument.ElementSpec.StartTagType);
    specs.add(spec);

    DefaultStyledDocument.ElementSpec[] arr = new DefaultStyledDocument.ElementSpec[specs.size()];
    specs.toArray(arr);
    insertSpecs(dest, dest.getLength(), arr);
}

protected static void insertSpecs(DefaultStyledDocument doc, int offset, DefaultStyledDocument.ElementSpec[] specs) {
    try {
        Method m=DefaultStyledDocument.class.getDeclaredMethod("insert", new Class[] {int.class, DefaultStyledDocument.ElementSpec[].class});
        m.setAccessible(true);
        m.invoke(doc, new Object[] {offset, specs});
    } catch (Exception e) {
        e.printStackTrace();
    }
}

protected static void fillSpecs(Element elem, ArrayList<DefaultStyledDocument.ElementSpec> specs, boolean includeRoot) throws BadLocationException{
    DefaultStyledDocument.ElementSpec spec;
    if (elem.isLeaf()) {
        String str=elem.getDocument().getText(elem.getStartOffset(), elem.getEndOffset()-elem.getStartOffset());
        spec=new DefaultStyledDocument.ElementSpec(elem.getAttributes(), 
                 DefaultStyledDocument.ElementSpec.ContentType,str.toCharArray(), 0, str.length());
        specs.add(spec);
    }
    else {
        if (includeRoot) {
            spec=new DefaultStyledDocument.ElementSpec(elem.getAttributes(), DefaultStyledDocument.ElementSpec.StartTagType);
            specs.add(spec);
        }
        for (int i=0; i<elem.getElementCount(); i++) {
            fillSpecs(elem.getElement(i), specs, true);
        }

        if (includeRoot) {
            spec=new DefaultStyledDocument.ElementSpec(elem.getAttributes(), DefaultStyledDocument.ElementSpec.EndTagType);
            specs.add(spec);
        }
    }
}

}