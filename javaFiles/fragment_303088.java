public class TimeFrame extends JPanel{
    JLabel time;
    Timer t ;
    JButton pause ;
    JButton start ;
    public TimeFrame(){

        t= new Timer(this);

        time = new JLabel("Time goes here", JLabel.CENTER);
        pause = new JButton ("Pause");
        start = new JButton ("Start");

        start.addActionListener(new starts());
        pause.addActionListener(new starts());
        add(time);
        add(start);
        add(pause);

        java.util.Timer updateTimer= new java.util.Timer();
        updateTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            t.update(int_sec,int_min,int_mil);
        }
        }, 0, 100);
    }    

    public void update(int s, int minute,int m){
        String sec = Integer.toString(s);
        String min = Integer.toString(minute);
        String mil = Integer.toString(m);
    if (s<=10){
            sec="0"+sec;
        }

        System.out.println(min+":"+sec+","+mil);
        time.setText(min+":"+sec+","+mil);
    }


   public class starts implements ActionListener{
    boolean firstTime=true;
    public void actionPerformed(ActionEvent event){
        if (firstTime){
            t.count();
            firstTime = false;
        }
        if(event.getSource() == start){
            t.shouldCount=true;
        }else{
            t.shouldCount=false;
        }
    }
}

}