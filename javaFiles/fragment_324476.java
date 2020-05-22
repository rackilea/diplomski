import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;

public class test
{
    public static void main(String[] args)
    {
         SwingUtilities.invokeLater(new Runnable()
        {
          public void run()
          {
            // now add it all to a frame
            JFrame j = new JFrame("Test");

            WorkBench right = new WorkBench();

            JScrollPane sp = new JScrollPane(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            sp.setAutoscrolls(false);

            sp.setViewportView(right);


            j.getContentPane().add(sp, BorderLayout.CENTER);

            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());
            right.addPortal(getPortal());



            SwingUtilities.invokeLater(new Runnable() {
                public void run() {
                    sp.getViewport().setViewPosition(new java.awt.Point(0, 0));
                }
          });


            // center the jframe, then make it visible
            j.setSize(800, 600);
            j.setLocationRelativeTo(null);
            j.setVisible(true);
          }
        });
      }


    public static JPanel getPortal()
    {
        JEditorPane swingbox = new JEditorPane();


        swingbox.setEditorKit(new HTMLEditorKit());

        swingbox.setOpaque(true);

        swingbox.setContentType("text/html");

      String htmlString = "<html>\n"
         + "<body>\n"
         + "<h1>Welcomfve!  sdsdsdsdsd sdsdsd sdsd sdsd sdsd </h1>\n"
         + "<h2>This is an H2 header. sdsdsdsdsd sdsdsd sdsd sdsd sdsd </h2>\n"
         + "<p>This is some sample text  sdsdsdsdsd sdsdsd sdsd sdsd sdsd </p>\n"
         + "<p><a href=\"http://devdaily.com/blog/\">devdaily blog</a></p>\n"
         + "</body>\n";
      swingbox.setText(htmlString);


        swingbox.setBackground(Color.WHITE);


        JPanel p = new JPanel(new BorderLayout());

        p.setBackground(Color.WHITE);

        JLabel title = new JLabel("Heading " );
        title.setBackground(Color.WHITE);
        p.add(title, BorderLayout.NORTH);



        p.add(swingbox, BorderLayout.CENTER);


        return p;
    }

    public static class WorkBench extends JPanel implements Scrollable
    {
        Box vertical_box = null;

        public WorkBench()
        {
            setLayout(new BorderLayout());

            this.vertical_box = Box.createVerticalBox();

            //**  Scenario A - no vertical scrolling  **
                add(this.vertical_box , BorderLayout.CENTER);

            //** Scenario B - no line wrapping **
                //JScrollPane sp = new JScrollPane(current );
                //sp.setViewportView(current );
                //add(sp, BorderLayout.CENTER);


        }

        public void addPortal(JPanel portal)
        {
            this.vertical_box.add(portal);

            validate();
        }

        @Override
        public Dimension getPreferredScrollableViewportSize() 
        {
            return getPreferredSize();
        }


        @Override
        public int getScrollableUnitIncrement(
                Rectangle visibleRect,
                int orientation, 
                int direction) 
        {
            return 20;
        }


        @Override
        public int getScrollableBlockIncrement(
                Rectangle visibleRect,
                int orientation, 
                int direction)
        {
            return 60;
        }


        @Override
        public boolean getScrollableTracksViewportWidth() 
        {
            return true;
        }


        @Override
        public boolean getScrollableTracksViewportHeight()
        {
             if (getParent() instanceof JViewport)
             {
                 return (((JViewport)getParent()).getHeight() > getPreferredSize().height);
             }

             return false;
        }
    }
}