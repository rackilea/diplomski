//not actually sure which of these import statements are really necessary, lol
import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JFrame;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Vector;
import java.util.concurrent.TimeUnit;

class HallOfFame extends JFrame implements ActionListener 
{

    private static final int FRAME_WIDTH    = 300;
    private static final int FRAME_HEIGHT   = 350;

    int numberOfRows=20;

    String[] name = new String[100];
    String[] time = new String[100];

    //long[] longArrayTime = new long[100];

    String[] saneTime = new String[100];

    /*it's been a */long[] longTime = new long[100];

    long second;
    long minute;
    long hour;
    long miliseconds;
     //Declare your objects here...

     public static void main(String[] args) 
     {
         HallOfFame frame = new HallOfFame();  
         frame.setVisible(true); // Display the frame
      }

    @SuppressWarnings("unchecked")  //without this line, a warning appears. i can find no need for it and it's annoying, so i got rid of it :P (It is in relation to the table)
    public HallOfFame( ) 
    {  

        try 
        {
            File inFile= new File("names.txt");
            FileReader fileReader= new FileReader(inFile);
            BufferedReader bufReader = new BufferedReader(fileReader);

            for(int i=0; i<100; i++)
            {
                 name[i]=bufReader.readLine();

            }
            bufReader.close();

            }
            catch(IOException tada)
            {
            JOptionPane.showMessageDialog(null, "Error loading high scores. Please ensure file system is accesible, and that 'name.txt' exists");
          }

          try 
          {
           File inFile= new File("times.txt");
           FileReader fileReader= new FileReader(inFile);
           BufferedReader bufReader = new BufferedReader(fileReader);

           for(int i=0; i<100; i++)
           {
            time[i]=bufReader.readLine();

        }
        bufReader.close();

    }
    catch(IOException tada)
    {
        JOptionPane.showMessageDialog(null, "Error loading high scores. Please ensure file system is accesible, and that 'name.txt' exists");
    }

    //finished reading scores
    for(int i=0;i<100;i++)
    {
        if(time[i]==null||time[i].equals(("0")))
        {
            time[i]="3699989"; //a very large value so that non-existant values are at the end of a sorted array
        }

        longTime[i] = Long.parseLong(time[i]);
    }
    //Arrays.sort(longTime); removed

    /* removed and replaced with a method which returns HH:mm:ss for given milliseconds
    for(int i=0;i<100;i++)
    {
        second = (longTime[i] / 1000) % 60;
        minute = (longTime[i] / (1000 * 60)) % 60;
        hour = (longTime[i] / (1000 * 60 * 60)) % 24;
        miliseconds = Long.parseLong((""+longTime[i]).substring(0,2));

        saneTime[i] = String.format("%02d:%02d:%d", minute, second, miliseconds);
    }*/

    class Player implements Comparable<Player>{     //added a class player with the atr. name and time
        String name;
        Long time;

        Player(String name, Long time){
            this.name = name;
            this.time = time;
        }
        @Override
        public int compareTo(Player p) {        // a compareTo method which is needed to sort a list of players
          return time.compareTo(p.time);        // sorting by time, you can change this to sort by name age or sth.else
        }
    }

    ArrayList<Player> playerslist = new ArrayList<>(); // an ArrayList to hold your data  
    for(int i=0;i<100;i++){
        Player p = new Player(name[i],longTime[i]);
        playerslist.add(p);
    }
    Collections.sort(playerslist);

    // set the frame properties
    setTitle("High Scores");
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    setLocationRelativeTo(null);
    setResizable(false);
    Image icon = new ImageIcon("trophy.png").getImage();   //why does this not work????
    setIconImage(icon);

    Object columns[] = { "Rank", "Time", "Name" };
    DefaultTableModel model = new DefaultTableModel(columns, 0);

       for(int i=0;i<numberOfRows;i++)
       {
           if(playerslist.get(i).time >1000000)//stop adding scores when array is empty (this large number is "empty" as 0 is defined to it above to make sorting the array work)
          {
            break;
           }
          Vector row = new Vector(numberOfRows);
          row.add((i+1));
          //row.add(time[i]);
          row.add(convertSecondsToHMmSs(playerslist.get(i).time));
          row.add(playerslist.get(i).name);
          model.addRow( row );
       }

    // set the content pane properties
    Container contentPane = getContentPane();   
    contentPane.setLayout(new GridLayout());
    contentPane.setBackground(Color.white);

    JTable table = new JTable( model );
    JScrollPane scrollPane = new JScrollPane(table);
    contentPane.add(scrollPane, BorderLayout.CENTER);

    for(int i=0;i<numberOfRows;i++)
    {
        table.setRowHeight(i, 30);
    }

    //create and place items frame's content pane

    // register 'Exit' upon closing as default close operation
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent event) // Actions
    {      
      JButton clickedButton = (JButton) event.getSource();        

    }

     public static String convertSecondsToHMmSs(long millis) {       // method to change milliseconds to HH:mm:ss
    return String.format("%02d:%02d:%02d", 
    TimeUnit.MILLISECONDS.toHours(millis),
    TimeUnit.MILLISECONDS.toMinutes(millis) -  
    TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)), 
    TimeUnit.MILLISECONDS.toSeconds(millis) - 
     TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis))); 
  }
}