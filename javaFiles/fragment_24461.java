import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class InputRedirection extends Box{

    public InputRedirection() {
        super(BoxLayout.X_AXIS);

        //Remap input
        //Create the input stream to be used as standard in
        final PipedInputStream pisIN = new PipedInputStream();
        //Create an end so we can put info into standard in
        PipedOutputStream posIN = new PipedOutputStream();
        //Wrap with a writer (for ease of use)
        final BufferedWriter standardIn = new BufferedWriter(new OutputStreamWriter(posIN));
        //Set standard in to use this stream
        System.setIn(pisIN);

        //Connect the pipes
        try {
            pisIN.connect(posIN);
        } catch (IOException e2) {
            e2.printStackTrace();
        }        

        //UI element where we're entering standard in
        final JTextField field = new JTextField(20);
        ActionListener sendText = new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    //Transfering the text to the Standard Input stream
                    standardIn.append(field.getText());
                    standardIn.flush();
                    field.setText("");
                    field.requestFocus();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }};

        field.addActionListener(sendText);
        add(field);

        //Why not - now it looks like a real messaging system
        JButton button = new JButton("Send");
        button.addActionListener(sendText);
        add(button);

        //Something using standard in
        //Prints everything from standard in to standard out.
        Thread standardInReader = new Thread(new Runnable(){

            @Override
            public void run() {
                boolean update = false;
                final StringBuffer s = new StringBuffer();
                while(true){
                    try {

                        BufferedInputStream stream = new BufferedInputStream(System.in);
                        while(stream.available() > 0){
                            int charCode = stream.read();
                            s.append(Character.toChars(charCode));
                            update = true;
                        }
                        if(update){
                            //Print whatever was retrieved from standard in to standard out.
                            System.out.println(s.toString());
                            s.delete(0, s.length());
                            update = false;
                        }

                    } catch (IOException e) {
                        e.printStackTrace();
                    } 
                }
            }});
        standardInReader.start();

    }

    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new InputRedirection());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}