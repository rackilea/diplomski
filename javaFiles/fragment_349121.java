import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.*;

public class AS4Temp extends JApplet implements ActionListener {
   JPanel p, p1, p2;

   JComboBox c;
   JList lchannels;
   JScrollPane jp;
   // !! Vector vt;
   private DefaultListModel<String> listModel = new DefaultListModel<>(); // !!
   Container con;

   public void init() {
      p = new JPanel();
      p.setLayout(new GridLayout(3, 3, 10, 10));

      // Genre
      p1 = new JPanel();
      c = new JComboBox();
      c.addItem("Please Select Genre of Channel");
      c.addItem("All Genres");
      c.addItem("Entertainment");
      c.addItem("Movie");
      c.addItem("News/Business");
      c.addItem("Sci-Fi");
      c.addItem("Sports");

      c.addActionListener(this);

      p1.add(c);

      p1.setLayout(new FlowLayout());
      p1.setBorder(new TitledBorder("Channel Genre"));

      // Channels

      p2 = new JPanel();
      // !! vt = new Vector();
      ChannelList cl = new ChannelList();

      // !! lchannels = new JList(vt);
      lchannels = new JList<>(listModel); // !!

      lchannels.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      jp = new JScrollPane(lchannels);
      cl.createList();
      /*
       * for(int i =0; i < cl.chList.length; i++){ char chGenre =
       * cl.chList[i].getChGenre(); if(chGenre == 'e')
       * vt.add(cl.chList[i].getChTitle()); }
       */
      p2.add(jp);
      p2.setBorder(new TitledBorder("Channel Titles Available"));
      p2.setLayout(new GridLayout(1, 1, 10, 10));
      // price

      // all panels
      p.add(p1);
      p.add(p2);

      con = getContentPane();
      con.add(p);
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      JComboBox c = (JComboBox) e.getSource();
      String genre = (String) c.getSelectedItem();
      System.out.println(genre);

      ChannelList cl = new ChannelList();
      cl.createList();

      switch (genre) {
      case "All Genres":
         for (int i = 0; i < cl.chList.length; i++) {
            char chGenre = cl.chList[i].getChGenre();
            // !! vt.add(cl.chList[i].getChTitle());
            listModel.addElement(cl.chList[i].getChTitle()); // !!
         }
         break;
      case "Entertainment":
         for (int i = 0; i < cl.chList.length; i++) {
            char chGenre = cl.chList[i].getChGenre();
            if (chGenre == 'e')
               // !! vt.add(cl.chList[i].getChTitle());
               listModel.addElement(cl.chList[i].getChTitle()); // !!
         }
         break;
      }

   }
}

// !! added to make your code compilable
// !! in the future, please don't force us to do this kludge
class ChannelList {

   public Channel[] chList;

   public ChannelList() {
      createList();
   }

   public void createList() {
      chList = new Channel[5];
      chList[0] = new Channel("Foobar1", 'e');
      chList[1] = new Channel("Foobar2", 'e');
      chList[2] = new Channel("Foobar3", 'e');
      chList[3] = new Channel("Foobar4", 'e');
      chList[4] = new Channel("Foobar5", 'e');
   }

}

// !! added to make your code compilable
// !! in the future, please don't force us to do this kludge
class Channel {
   private String title;
   private char genre;

   public Channel(String title, char genre) {
      this.title = title;
      this.genre = genre;
   }

   public char getChGenre() {
      return genre;
   }

   public String getChTitle() {
      return title;
   }

   @Override
   public String toString() {
      return "Channel [title=" + title + ", genre=" + genre + "]";
   }

}