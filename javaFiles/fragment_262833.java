import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class DynamicWrite implements ActionListener
{
    JFrame frame = new JFrame("TextArea");
    JTextArea tArea = new JTextArea(10,20);
    JButton button = new JButton("Click");
    JScrollPane pane = new JScrollPane(tArea);
    SwingWorker worker;
    String s= "Java is an Object Oriented Programming langauge...Java is static typed language...asbfldfjsdj";//some random String
    public void prepareAndShowGUI()
    {
        Container container = frame.getContentPane();
        container.add(pane);container.add(button,BorderLayout.NORTH);
        tArea.setLineWrap(true);
        tArea.setWrapStyleWord(true) ;
        button.addActionListener(this);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {
        if(evt.getSource()==button)
        {
            tArea.setText("");
            if (worker!=null)
            {
                worker.cancel(true);
            }
            worker = new SwingWorker()
            {
                @Override
                protected Integer doInBackground()//Perform the required GUI update here.
                {
                    try
                    {
                        for(int i = 0;i<s.length();i++)
                        {
                            tArea.append(String.valueOf(s.charAt(i)));
                            Thread.sleep(5);
                        }
                    }catch(Exception ex){}
                    return 0;
                }       
            };
            worker.execute();//Schedules this SwingWorker for execution on a worker thread.
        }
    }   
    public static void main(String st[])
    {
        DynamicWrite dyna = new DynamicWrite();
        dyna.prepareAndShowGUI();
    }
}