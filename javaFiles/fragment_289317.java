public class MusicPlayer extends JFrame{

    private static final int WIDTH = 400;
    private static final int HEIGHT = 400;
    private JLabel songsList,songPlaying,c;
    private JTextField enterSong;
    private AddSong input;

    public MusicPlayer(){

        //Text box enterSong, input passed to actionListener
        input = new AddSong();
        enterSong = new JTextField(10);
        enterSong.addActionListener(input);

        //Numbers the quadrents
        songsList = new JLabel("No songs in list",SwingConstants.CENTER);
        songPlaying = new JLabel("2",SwingConstants.CENTER);
        c = new JLabel("c",SwingConstants.CENTER);

        //Makes and sets size of pane
        Container pane = getContentPane();
        pane.setLayout(new GridLayout(2,2));

        //Add JLabels to panes in the container
        pane.add(songsList);
        pane.add(songPlaying);
        pane.add(c);
        pane.add(enterSong);

        //adding a key listenr to the Jframe is not need
        //the  enterSong.addActionListener(input); does the work

        add(songsList);
        pack();

        setTitle("Andrew's Music Player");
        setSize(WIDTH,HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    public class AddSong implements ActionListener{

        //List of Songs
        ArrayList<String> songList = new ArrayList<>();

        public AddSong(){ }

        @Override
        public void actionPerformed(ActionEvent e){

            String song;
            //get the text
            song = enterSong.getText();

            //add current text string to list
            songList.add(song);

            String songListAsString = printSongs(songList);

            //update display with new song
            songsList.setText(songListAsString);

            //clear text field
            enterSong.setText("");
        }

        public String printSongs(ArrayList<String> songList){

            //using string builder is more efficient
            //to have multiple lines in a JLabel you have to use
            //html tags
            //a JList would be more appropriiate
            StringBuilder sb = new StringBuilder("<html>");

            for(int i = 0; i < songList.size(); i++){
                sb.append("<p>")
                  .append(songList.get(i))
                  .append("</p>");
            }

            sb.append("</html>");
            return sb.toString();
        }
    }

    public static void main(String args[]){
        MusicPlayer boi = new MusicPlayer();
    }
}