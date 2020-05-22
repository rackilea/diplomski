package com.sg2net.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.xhtmlrenderer.pdf.ITextRenderer;

import com.lowagie.text.DocumentException;

public class XHTMLRenderer8 {

    /**
     * @author Giovanni Cuccu
     */
    public static void main(String[] args) throws FileNotFoundException, DocumentException {
        ITextRenderer renderer = new ITextRenderer();
        String content="<html><head><style>\n" +
          "div.header {\n" +
          "display: block; text-align: center;\n" + 
          "position: running(header);}\n" +
          "div.footer {\n" +
          "display: block; text-align: center;\n" + 
          "position: running(footer);}\n" +
          "div.content {page-break-after: always;}" +
          "@page { @top-center { content: element(header) }}\n " +
          "@page { @bottom-center { content: element(footer) }}\n" +
          "</style></head>\n" +
          "<body><div class='header'>Header</div><div class='footer'>Footer</div><div class='content'>Page1</div><div>Page2</div></body></html>";
        renderer.setDocumentFromString(content);
        renderer.layout();
        renderer.createPDF(new FileOutputStream("test.pdf"));

    }

}