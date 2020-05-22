import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.xml.bind.DatatypeConverter;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class HexTextField extends JTextField implements DocumentListener
{
    private static final long serialVersionUID= -6694532039668603522L;
    private boolean filtering= false;

    public HexTextField()
    {
        super();
        getDocument().addDocumentListener(this);
    }

    @Override
    public void changedUpdate(DocumentEvent e)
    {
        filterText();
    }

    @Override
    public void insertUpdate(DocumentEvent e)
    {
        filterText();
    }

    @Override
    public void removeUpdate(DocumentEvent e)
    {
        filterText();
    }

    private void filterText()
    {
        if(filtering)
            return;
        filtering= true;

        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                String input= getText().toUpperCase();
                String filtered= "";
                int index= 0;

                // filter
                for(int i= 0; i < input.length(); i++)
                {
                    char c= input.charAt(i);
                    if("0123456789ABCDEF".indexOf(c) >= 0)  // hex only
                    {
                        filtered+= c;
                        if(index++ % 2 == 1 && i != input.length() - 1)
                            filtered+= " "; // whitespace after each byte
                    }
                }

                // limit size
                int maxBytes= 256;
                if(filtered.length() > 3 * maxBytes)
                {
                    filtered= filtered.substring(0, 3 * maxBytes);
                    Toolkit.getDefaultToolkit().beep();
                }

                setText(filtered);
                filtering= false;
            }
        });
    }

    public byte[] getBytes()
    {
        String text= getText().replace(" ", "");
        if(text.length() == 0)
            return null;

        if(text.length() % 2 == 1)
            text= text.substring(0, text.length()-1) + "0" + text.charAt(text.length()-1);

        byte[] bytes= DatatypeConverter.parseHexBinary(text);
        if(bytes.length == 0)
            return null;

        return bytes;
    }
}